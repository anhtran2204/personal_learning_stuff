package com.company;

public class Challenge8 {
    
    public static void main(String[] args) {
        NewTutor newTutor = new NewTutor();
        NewStudent newStudent = new NewStudent(newTutor);
        newTutor.setStudent(newStudent);
        
        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                newTutor.studyTime();
            }
        });
        
        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    tutorThread.join();
                } catch (InterruptedException e){
        
                }
                newStudent.handInAssignment();
            }
        });
        
        tutorThread.start();
        studentThread.start();
        
        
        /*
         * Challenge #8: Spot and fix the problem
         *
         * # Solution #
         * Add the code below in the run() method of the studentThread before
         * calling the handInAssignment() method.
         * try {
         *      tutorThread.join();
         * } catch (InterruptedException e) { }
         *
         * Also removed all the synchronized keywords in the methods to solve
         * over-synchronizing the threads.
         * */
    }
}

class Tutor {
    
    private NewStudent newStudent;
    
    public synchronized void setStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }
    
    public void studyTime() {
        System.out.println("Tutor has arrived");
        try {
            // wait for student to arrive and hand in assignment
            Thread.sleep(300);
        } catch (InterruptedException e) {
        
        }
        newStudent.startStudy();
        System.out.println("Tutor is studying with student");
    }
    
    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class Student {
    
    private NewTutor newTutor;
    
    Student(NewTutor newTutor) {
        this.newTutor = newTutor;
    }
    
    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }
    
    public void handInAssignment() {
        System.out.println("Student handed in assignment");
        newTutor.getProgressReport();
    }
}
