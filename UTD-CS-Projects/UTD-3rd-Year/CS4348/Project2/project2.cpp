#include <iostream>
#include <vector>
#include <pthread.h>

using namespace std;

vector<pthread_t> doctors;
vector<pthread_t> nurses;
vector<pthread_t> patients;

void* run(void* id) {
    printf("thread #%d created!\n", id);
    pthread_exit(NULL);
}

int main(int argc, char const *argv[])
{
    for (int i = 0; i < 3; i++)
    {
        pthread_t doctor;
        int rc = pthread_create(&doctor, NULL, NULL, NULL);
        doctors.push_back(doctor);
        printf("thread #%d created.\n", i);
    }
    
    return 0;
}
