//#include "apue.h"
//#include <pthread.h>
//pthread_t ntid;
//void
//printids(const char *s)
//{
//    pid_t pid;
//    pthread_t tid;
//    pid = getpid();
//    tid = pthread_self();
//    printf("%s pid %lu tid %lu (0x%lx)\n", s, (unsigned long)pid,
//           (unsigned long)tid, (unsigned long)tid);
//}
//void *
//thr_fn(void *arg)
//{
//    printids("new thread: ");
//    return((void *)0);
//}
//int
//main(void)
//{
//    int err;
//    err = pthread_create(&ntid, NULL, thr_fn, NULL);
//    if (err != 0)
//        err_exit(err, "can’t create thread");
//    printids("main thread:");
//    sleep(1);
//    exit(0);
//}

//#include <stdio.h>
//#include <pthread.h>
//#include <stdlib.h>
//#include <unistd.h>
//
//#define NUM_THREADS 5
//void *print_hello(void *threadid)
//{
//    long tid;
//    tid = (long) threadid;
//    printf("Hello World! It’s me, thread #%ld!\n", tid);
//    pthread_exit(NULL);
//}
//int main (int argc, char *argv[])
//{
//    pthread_t threads[NUM_THREADS];
//    int rc;
//    long t;
//    for (t = 0; t < NUM_THREADS; t++)
//    {
//        printf("In main: creating thread %ld\n", t);
//        rc = pthread_create(threads + t, NULL, print_hello, (void *) t);
//        if (rc)
//        {
//            printf("ERROR; return code from pthread_create() is %d\n", rc);
//            exit(-1);
//        }
//        sleep(1);
//    }
//
//    for (t = 0; t < NUM_THREADS; t++) {
//        printf("%lu\n", threads[t]);
//    }
//    pthread_exit(NULL);
//}