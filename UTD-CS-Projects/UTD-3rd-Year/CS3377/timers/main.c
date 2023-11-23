#include <stdio.h>
#include <sys/time.h>
#include <signal.h>
#include <unistd.h>

#define MAX_TIMERS 10

// Timer structure to hold timer information
typedef struct {
    int id;
    struct timeval expire_time;
    void (*callback)(int);
} Timer;

// Priority queue implementation for managing timers
Timer timers[MAX_TIMERS];
int num_timers = 0;

void timer_callback(int signum) {
    // Check if any timers have expired
    struct timeval current_time;
    gettimeofday(&current_time, NULL);

    while (num_timers > 0 && timercmp(&timers[0].expire_time, &current_time, <=)) {
        Timer expired_timer = timers[0];
        // Remove the expired timer (replace with the last timer in the queue)
        timers[0] = timers[num_timers - 1];
        num_timers--;

        // Perform the callback for the expired timer
        expired_timer.callback(expired_timer.id);
    }

    // Reset the timer for the next expiration time
    if (num_timers > 0) {
        struct itimerval timer;
        long microseconds;
        timersub(&timers[0].expire_time, &current_time, &timer.it_value);
        timer.it_interval.tv_sec = 0;
        timer.it_interval.tv_usec = 0;
        setitimer(ITIMER_REAL, &timer, NULL);
    }
}

void set_timer(int id, unsigned int seconds, void (*callback)(int)) {
    if (num_timers >= MAX_TIMERS) {
        printf("Cannot set more timers, limit reached.\n");
        return;
    }

    Timer new_timer;
    new_timer.id = id;
    gettimeofday(&new_timer.expire_time, NULL);
    new_timer.expire_time.tv_sec += seconds;
    new_timer.callback = callback;

    // Insert the new timer into the priority queue
    int i = num_timers;
    while (i > 0 && timercmp(&new_timer.expire_time, &timers[(i - 1) / 2].expire_time, <)) {
        timers[i] = timers[(i - 1) / 2];
        i = (i - 1) / 2;
    }
    timers[i] = new_timer;
    num_timers++;

    // If this timer is the earliest one, set the timer signal
    if (i == 0) {
        signal(SIGALRM, timer_callback);
        struct itimerval timer;
        long microseconds;
        gettimeofday(&timer.it_value, NULL);
        timersub(&new_timer.expire_time, &timer.it_value, &timer.it_value);
        timer.it_interval.tv_sec = 0;
        timer.it_interval.tv_usec = 0;
        setitimer(ITIMER_REAL, &timer, NULL);
    }
}

// Example callback function
void timer_callback_function(int id) {
    printf("Timer %d expired!\n", id);
}

int main() {
    set_timer(1, 5, timer_callback_function);
    set_timer(2, 3, timer_callback_function);
    set_timer(3, 8, timer_callback_function);

    // Do other tasks while timers are running
    // ...

    // Sleep to allow timers to expire
    sleep(10);

    return 0;
}
