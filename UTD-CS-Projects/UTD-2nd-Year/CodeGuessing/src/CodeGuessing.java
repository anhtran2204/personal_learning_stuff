import java.util.Scanner;

public class CodeGuessing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int card_a, card_b;
        card_a = sc.nextInt(); // taking input of alice card
        card_b = sc.nextInt();
        String sequence = sc.next(); // taking string
        int diff = card_b - card_a; // taking difference

        if (diff == 3) {
            if (sequence.charAt(0) == 'A' && sequence.charAt(3) == 'A') {
                int bob_first = card_a + 1;
                int bob_second = card_a + 2;

                System.out.println(bob_first + " " + bob_second);
            } else {
                System.out.println(-1);
            }
        } else if (diff == 2) {
            //checking position of alice card
            if ((sequence.charAt(0) == 'A' && sequence.charAt(2) == 'A')) {
                if (card_a == 6 && card_b == 8) {
                    System.out.println(7 + " " + 9);
                } else {
                    System.out.println(-1);
                }
            } else if ((sequence.charAt(1) == 'A' && sequence.charAt(3) == 'A')) {
                if (card_a == 2 && card_b == 4) {
                    System.out.println(1 + " " + 3);
                } else {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);
            }
        } else if (diff == 1) {
            if ((sequence.charAt(0) == 'A' && sequence.charAt(1) == 'A')) {
                if (card_a == 6 && card_b == 7) {
                    System.out.println(8 + " " + 9);

                } else {
                    System.out.println(-1);
                }
            } else if ((sequence.charAt(2) == 'A' && sequence.charAt(3) == 'A')) {
                if (card_a == 3 && card_b == 4) {
                    System.out.println(1 + " " + 2);
                } else {
                    System.out.println(-1);
                }

            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }

    }
}
