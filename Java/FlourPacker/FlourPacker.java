public class FlourPacker {
    public static void main(String[] args) {
        System.out.println(canPack(2, 0, 9));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        if ((bigCount * 5) + smallCount >= goal) {                      /// This is my code based on Eddie's
            if (goal % 5 != 0) {
                return (smallCount >= goal % 5);
            } return true;
        } else if (bigCount == 0) {
            if (smallCount >= goal) {
                return true;
            }
        } return false;

        // if ((bigCount*5) + smallCount < goal) {
        //     return false;
        // }                                                            /// This is the solution example from Udemy by Eddie

        // if (bigCount == 0) {
        //     if (smallCount >= goal) {
        //         return true;
        //     } 
        // }
        // return (smallCount >= goal % 5);
    }
}