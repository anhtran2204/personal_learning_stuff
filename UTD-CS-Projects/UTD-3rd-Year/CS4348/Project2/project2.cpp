#include <iostream>
#include <vector>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

using namespace std;

/* Constants */
const int TIMER = 1; // seconds of pause between steps
const int MAX_PATIENTS = 15; // max number of patient threads
const int MAX_DOCTORS = 3; // max number of doctor threads

vector<pthread_t> doctors;
vector<pthread_t> nurses;
vector<pthread_t> patients;

/* Shared Semaphores */
sem_t consumeReceptionist;
sem_t produceReceptionist;
sem_t waitingRoomSem;
sem_t enteredSem;
sem_t doctorSem;
sem_t nurseSem;

/* Test Semaphores */
sem_t demoSem;

void init_sem() {
    sem_init(&demoSem, 0, 1);
}

void* run(void* id) {
    sem_wait(&demoSem);
    printf("thread #%d created!\n", id);
    sleep(TIMER);
    // pthread_exit(NULL);
    sem_post(&demoSem);
}

int main(int argc, char const *argv[])
{
    // if (argc != 3) {
    //     printf("Usage: %s  <number_of_doctors> <number_of_patients>", argv[0]);
    //     return -1;
    // }

    /* section for testing functions */
    init_sem();
    int rc;

    for (int i = 0; i < 3; i++)
    {
        pthread_t thread;
        if (rc = pthread_create(&thread, NULL, run, (void *) i)) {
            printf("thread creation failed: %d", rc);
        }
        pthread_join(thread, NULL);
    }
    sem_destroy(&demoSem);
    printf("thread creation complete...\n");
    /*********************************/
    
    return 0;
}
