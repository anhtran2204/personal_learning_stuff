#include <stdlib.h>
#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

struct job {
    struct job *j_next;
    struct job *j_prev;
    pthread_t j_id; /* tells which thread handles this job */
/* ... more stuff here ... */
};
struct queue {
    struct job *q_head;
    struct job *q_tail;
    pthread_rwlock_t q_lock;
};

pthread_cond_t qready = PTHREAD_COND_INITIALIZER;
pthread_mutex_t qlock = PTHREAD_MUTEX_INITIALIZER;

void
printids(const char *s)
{
    pid_t pid;
    pthread_t tid;
    pid = getpid();
    tid = pthread_self();
    printf("%s pid %lu tid %lu (0x%lx)\n", s, (unsigned long)pid,
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
        qp->q_tail = jp; /* list was empty */
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
        qp->q_head = jp; /* list was empty */
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
    pthread_rwlock_unlock(&qp->q_lock);
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
    struct queue my_queue;
    queue_init(&my_queue);
    pthread_t threads[5];
    struct job jobs[5];
    for (int i = 0; i < 5; ++i) {
        int err = pthread_create(&threads[i], NULL, &thr_fn, (void *) i);
        job_append(&my_queue, &jobs[i]);
        jobs[i].j_id = threads[i];
        if (err)
        {
            printf("ERROR; return code from pthread_create() is %d\n", err);
            exit(-1);
        }
        sleep(1);
    }
    return 0;
}