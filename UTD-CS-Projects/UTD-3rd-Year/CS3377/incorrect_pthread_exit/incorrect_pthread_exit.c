#include "apue.h"
#include <pthread.h>
struct foo {
    int a, b, c, d;
};

struct foo glb_fp;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void
printfoo(const char *s, const struct foo *fp)
{
    printf("%s", s);
    printf(" structure at 0x%lx\n", (unsigned long)fp);
    printf(" foo.a = %d\n", fp->a);
    printf(" foo.b = %d\n", fp->b);
    printf(" foo.c = %d\n", fp->c);
    printf(" foo.d = %d\n", fp->d);
}
void *
thr_fn1(void *arg)
{
    pthread_mutex_lock(&mutex);
    glb_fp.a = 1;
    glb_fp.b = 2;
    glb_fp.c = 3;
    glb_fp.d = 4;
    printfoo("thread 1:\n", &glb_fp);
    pthread_mutex_unlock(&mutex);
    pthread_exit((void *)&glb_fp);
}
void *
thr_fn2(void *arg)
{
    pthread_mutex_lock(&mutex);
    printf("thread 2: ID is %lu\n", (unsigned long)pthread_self());
    pthread_mutex_unlock(&mutex);
    pthread_exit((void *)0);
}
int
main(void)
{
    int err;
    pthread_t tid1, tid2;
    err = pthread_create(&tid1, NULL, thr_fn1, NULL);
    if (err != 0)
        err_exit(err, "can’t create thread 1");
    err = pthread_join(tid1, NULL);
    if (err != 0)
        err_exit(err, "can’t join with thread 1");
    sleep(1);
    printf("parent starting second thread\n");
    err = pthread_create(&tid2, NULL, thr_fn2, NULL);
    if (err != 0)
        err_exit(err, "can’t create thread 2");
    err = pthread_join(tid2, NULL);
    if (err != 0)
        err_exit(err, "can’t join with thread 2");
    sleep(1);
    printfoo("parent:\n", &glb_fp);
    exit(0);
}