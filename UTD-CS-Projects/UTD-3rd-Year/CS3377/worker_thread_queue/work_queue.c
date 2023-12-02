#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "apue.h"

#define NUM_THREADS 5

struct job {
    struct job *j_next;
    struct job *j_prev;
    pthread_t   j_id;   /* tells which thread handles this job */
    /* ... more stuff here ... */
};

struct queue {
    struct job       *q_head;
    struct job       *q_tail;
    pthread_rwlock_t  q_lock;
};

pthread_cond_t qready = PTHREAD_COND_INITIALIZER;
pthread_mutex_t qlock = PTHREAD_MUTEX_INITIALIZER;


void job_init(struct job *newJob){
    newJob->j_next = NULL;
    newJob->j_prev = NULL;
    newJob->j_id = 0;
}

void
printids(const char *s)
{
    pid_t pid;
    pthread_t tid;
    pid = getpid();
    tid = pthread_self();
    printf("+ %s pid %lu tid %lu (0x%lx)\n", s, (unsigned long)pid,
           (unsigned long)tid, (unsigned long)tid);
}

void *
thr_fn(void *arg)
{
    printids("Thread ID:");
    return((void *)0);
}

/*
 * Initialize a queue.
 */
int
queue_init(struct queue *qp)
{
    int err;

    qp->q_head = NULL;
    qp->q_tail = NULL;
    err = pthread_rwlock_init(&qp->q_lock, NULL);
    if (err != 0)
        return(err);
    /* ... continue initialization ... */
    pthread_cond_init(&qready, NULL);
    return(0);
}

/*
 * Insert a job at the head of the queue.
 */
void
job_insert(struct queue *qp, struct job *jp)
{
    pthread_mutex_lock(&qlock);
    pthread_rwlock_wrlock(&qp->q_lock);
    jp->j_next = qp->q_head;
    jp->j_prev = NULL;
    if (qp->q_head != NULL)
        qp->q_head->j_prev = jp;
    else
        qp->q_tail = jp;	/* list was empty */
    qp->q_head = jp;
    pthread_rwlock_unlock(&qp->q_lock);
    pthread_mutex_unlock(&qlock);
    pthread_cond_signal(&qready);
}

/*
 * Append a job on the tail of the queue.
 */
void
job_append(struct queue *qp, struct job *jp)
{
    pthread_mutex_lock(&qlock);
    pthread_rwlock_wrlock(&qp->q_lock);
    jp->j_next = NULL;
    jp->j_prev = qp->q_tail;
    if (qp->q_tail != NULL)
        qp->q_tail->j_next = jp;
    else
        qp->q_head = jp;	/* list was empty */
    qp->q_tail = jp;
    pthread_rwlock_unlock(&qp->q_lock);
    pthread_mutex_unlock(&qlock);
    pthread_cond_signal(&qready);
}

/*
 * Remove the given job from a queue.
 */
void
job_remove(struct queue *qp, struct job *jp)
{
    pthread_mutex_lock(&qlock);
    pthread_rwlock_wrlock(&qp->q_lock);
    if (jp == qp->q_head) {
        qp->q_head = jp->j_next;
        if (qp->q_tail == jp)
            qp->q_tail = NULL;
        else
            jp->j_next->j_prev = jp->j_prev;
    } else if (jp == qp->q_tail) {
        qp->q_tail = jp->j_prev;
        jp->j_prev->j_next = jp->j_next;
    } else {
        jp->j_prev->j_next = jp->j_next;
        jp->j_next->j_prev = jp->j_prev;
    }
    printf("-> Removed job from queue.\n");
    pthread_rwlock_unlock(&qp->q_lock);
    pthread_mutex_unlock(&qlock);
    pthread_cond_signal(&qready);
}

/*
 * Find a job for the given thread ID.
 */
struct job *
job_find(struct queue *qp, pthread_t id)
{
    struct job *jp;

    if (pthread_rwlock_rdlock(&qp->q_lock) != 0)
        return(NULL);

    for (jp = qp->q_head; jp != NULL; jp = jp->j_next)
        if (pthread_equal(jp->j_id, id))
            break;

    pthread_rwlock_unlock(&qp->q_lock);
    return(jp);
}

int
main() {
    struct queue myQueue;
    pthread_t threads[NUM_THREADS];
    queue_init(&myQueue);
    int rc;
    long t;
    int NUM_JOBS = NUM_THREADS;
    struct job jobs[NUM_JOBS];
    for (t = 0; t < NUM_THREADS; t++) {
        job_init(&jobs[t]);
        rc = pthread_create(threads + t, NULL, thr_fn, (void *) t);
        job_append(&myQueue, &jobs[t]);
        jobs[t].j_id = *(threads + t);
        printf("%p, %p, %lu \n", jobs[t].j_next, jobs[t].j_prev, jobs[t].j_id);
        if (rc)
        {
            printf("ERROR; return code from pthread_create() is %d\n", rc);
            exit(-1);
        }
        sleep(1);
    }

    struct job *itr = myQueue.q_head;
    int i = 0;
    printf("\n");
    while (itr != NULL) {
        printf("Job ID: %lu\n", itr->j_id);
        itr = itr->j_next;
        job_remove(&myQueue, &jobs[i]);
        i++;
    }
    return 0;
}