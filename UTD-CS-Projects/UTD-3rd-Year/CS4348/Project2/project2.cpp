#include <iostream>
#include <vector>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

using namespace std;

/* Constants */
const int TIMER = 1;         // seconds of pause between steps
const int MAX_PATIENTS = 15; // max number of patient threads
const int MAX_DOCTORS = 3;   // max number of doctor threads

vector<pthread_t> doctors;
vector<pthread_t> nurses;
vector<pthread_t> patients;

/* Shared Semaphores */
// sem_t consumeReceptionist;
// sem_t produceReceptionist;
// sem_t waitingRoomSem;
// sem_t enteredSem;
// sem_t doctorSem;
// sem_t nurseSem;

/* Test Semaphores */
sem_t demoSem;
sem_t doctorSem;
sem_t nurseSem;
sem_t receptionistSem;
sem_t patientSem;

sem_t exited;

void init_sem()
{
    if (sem_init(&demoSem, 0, 1) == -1) {
        cerr << "Error: semaphore" << endl;
    }
    if (sem_init(&doctorSem, 0, 0) == -1) {
        cerr << "Error: semaphore" << endl;
    }
    if (sem_init(&nurseSem, 0, 1)  == -1) {
        cerr << "Error: semaphore" << endl;
    }
    if (sem_init(&receptionistSem, 0, 1) == -1) {
        cerr << "Error: semaphore" << endl;
    }
    if (sem_init(&patientSem, 0, 1) == -1) {
        cerr << "Error: semaphore" << endl;
    }
    if (sem_init(&exited, 0, 0) == -1) {
        cerr << "Error: semaphore" << endl;
    }
}

void *run(void *id)
{
    sem_wait(&demoSem);
    printf("thread #%ld created!\n", (long) id);
    sleep(TIMER);
    sem_post(&demoSem);
}

void *doctor(void *arg) {
    sem_wait(&doctorSem);
    printf("doctor %ld checking...\n", (long) arg);
    sleep(TIMER);
    sem_post(&nurseSem);
    sem_post(&exited);
    sleep(TIMER);
}

void *nurse(void *arg) {
    sem_wait(&nurseSem);
    printf("nurse %ld attending...\n", (long) arg);
    sleep(TIMER);
    sem_post(&doctorSem);
}

void *receptionist(void *arg) {
    sem_wait(&receptionistSem);
    printf("receptionist registering...\n");
    sleep(TIMER);
    sem_post(&receptionistSem);
}

void *patient(void *arg) {
    sem_wait(&patientSem);
    printf("patient %ld entering...\n", (long) arg);
    sleep(TIMER);
    sem_post(&patientSem);
    sem_wait(&exited);
    printf("patient %ld leaving...\n", (long) arg);
    sleep(TIMER);
}

int main(int argc, char const *argv[])
{
    if (argc != 3)
    {
        printf("Usage: %s  <number_of_doctors> <number_of_patients>", argv[0]);
        return -1;
    }

    /* section for testing functions */
    init_sem();
    int rc;

    pthread_t receptionistThread;
    sleep(TIMER);
    for (long i = 0; i < 3; i++)
    {
        // pthread_t thread;
        pthread_t doctorThread;
        pthread_t nurseThread;
        pthread_t patientThread;
        // if (rc = pthread_create(&thread, NULL, run, (void *)i))
        // {
        //     printf("Error: pthread_create() failed\n");
        //     exit(EXIT_FAILURE);
        // }
        if (rc = pthread_create(&receptionistThread, NULL, receptionist, NULL))
        {
            printf("Error: pthread_create() failed\n");
            exit(EXIT_FAILURE);
        }
        pthread_join(receptionistThread, NULL);
        if (rc = pthread_create(&patientThread, NULL, patient, (void *) (i+1)))
        {
            printf("Error: pthread_create() failed\n");
            exit(EXIT_FAILURE);
        }
        sleep(TIMER);
        if (rc = pthread_create(&nurseThread, NULL, nurse, (void *) (i+1)))
        {
            printf("Error: pthread_create() failed\n");
            exit(EXIT_FAILURE);
        }
        sleep(TIMER);
        if (rc = pthread_create(&doctorThread, NULL, doctor, (void *) (i+1)))
        {
            printf("Error: pthread_create() failed\n");
            exit(EXIT_FAILURE);
        }
        sleep(TIMER);
    
        doctors.push_back(doctorThread);
        nurses.push_back(nurseThread);
        patients.push_back(patientThread);
    }

    for (int i = 0; i < doctors.size(); i++)
    {
        pthread_join(doctors.at(i), NULL);
        pthread_join(nurses.at(i), NULL);
        pthread_join(patients.at(i), NULL);
    }

    sem_destroy(&demoSem);
    sem_destroy(&doctorSem);
    sem_destroy(&nurseSem);
    sem_destroy(&patientSem);
    sem_destroy(&receptionistSem);
    printf("thread creation complete...\n");
    /*********************************/

    return 0;
}