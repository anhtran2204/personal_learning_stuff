package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        int counter = 1;

        long startTime = System.nanoTime();        // This is used to determine the runtime of a program
        while (true) {
//            if ((counter % 8 == 0) && (counter % 9 == 0) && (counter % 11 == 0)
//                    && (counter % 13 == 0) && (counter % 14 == 0) && (counter % 15 == 0)
//                    && (counter % 16 == 0) && (counter % 17 == 0) && (counter % 18 == 0)
//                    && (counter % 19 == 0) && (counter % 20 == 0)) {
//                System.out.println(counter);
//                break;
//            }
            if (counter % 2 == 0 && counter % 4 == 0 && counter % 5 == 0 && counter % 6 == 0 && counter % 7 == 0 && counter % 8 == 0 && counter % 9 == 0) {
                System.out.println(counter);
                break;
            }
            counter++;
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime is: " + totalTime);
    }
}
