public class BarkingDog {
    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 20));
        System.out.println(shouldWakeUp(false, 8));;
        System.out.println(shouldWakeUp(true, 24));;
        System.out.println(shouldWakeUp(true, 7));;
        System.out.println(shouldWakeUp(true, 23));
    }

    public static boolean shouldWakeUp(boolean barking , int hourOfDay){
        if(hourOfDay >= 0 && hourOfDay <= 23) {
            if((hourOfDay < 8 || hourOfDay > 22) && barking) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}