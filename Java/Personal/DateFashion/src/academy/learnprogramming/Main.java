package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        System.out.println(dateFashion(5,10));
        System.out.println(dateFashion(5, 2));
        System.out.println(dateFashion(5,5));
        System.out.println(dateFashion(3,3));
        System.out.println(dateFashion(10,2));
        System.out.println(dateFashion(2,9));
        System.out.println(dateFashion(9,9));
        System.out.println(dateFashion(10,5));
        System.out.println(dateFashion(2,2));
        System.out.println(dateFashion(3,7));
        System.out.println(dateFashion(2,7));
        System.out.println(dateFashion(6,2));


    }

    public static int dateFashion(int you, int date) {
        if ((you >= 0 && you <= 10) && (date >= 0 && date <= 10)) {
            if (you <= 2 || date <= 2) {
                return 0;
            } else if (you >= 8 || date >= 8){
                return 2;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
