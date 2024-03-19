#include <iostream>
#include <vector>
#include <pthread.h>
#include <semaphore.h>

using namespace std;

/* Constants */
const int TIMER = 100; // milliseconds of pause between steps
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

void* run(void* id) {
    printf("thread #%d created!\n", id);
    pthread_exit(NULL);
}

int main(int argc, char const *argv[])
{
    if (argc != 3) {
        printf("Usage: %s  <number_of_doctors> <number_of_patients>", argv[0]);
        return -1;
    }

    for (int i = 0; i < 3; i++)
    {
        pthread_t doctor;
        int rc = pthread_create(&doctor, NULL, NULL, NULL);
        doctors.push_back(doctor);
        printf("thread #%d created.\n", i);
    }
    
    return 0;
}
