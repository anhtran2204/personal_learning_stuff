package Demo;

import java.util.Scanner;

public class Demo {
    private enum TableStatus {
        OPEN,
        SEATED,
        ORDERED,
        SERVED
    }

    private static TableStatus status = TableStatus.OPEN;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\r?\n");
        System.out.println(s.next());
        System.out.println(s.nextLine());

//        String s = "P10";
//        if (s.matches("P\\d+")) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }


//        System.out.println(getTableStatus());
//        Scanner s = new Scanner(System.in);
//
//        int num = s.nextInt();
//        setTableStatus(num);
//        System.out.println(getTableStatus());
//
//        if (num == 1 && getTableStatus().toString().equals("SEATED")) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
    }

    public static TableStatus getTableStatus() {
        return status;
    }

    public static void setTableStatus(int newStatus) {
        if (newStatus < TableStatus.values().length) {
            switch (newStatus) {
                case 0:
                    break;

                case 1:
                    status = TableStatus.SEATED;
                    break;

                case 2:
                    status = TableStatus.ORDERED;
                    break;

                case 3:
                    status = TableStatus.SERVED;
                    break;
            }
        }
    }
}
