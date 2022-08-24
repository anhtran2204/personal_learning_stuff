package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        System.out.println(getTriplet());
    }

    // I did this by myself :)))
    public static int getTriplet() {
        long startTime = System.nanoTime();

        int product = 0;
        for (int x = 1; x < 1000; x++) {
            for (int y = 1; y < 1000; y++) {
                for (int z = 1; z < 1000; z++) {
                    if (Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)) {
                        if (x + y + z == 1000) {
                            product = x * y * z;
                            break;
                        }
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime: " + totalTime + " nanoseconds");
        return product;
    }
}
