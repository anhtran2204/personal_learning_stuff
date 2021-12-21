public class PlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 33));
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (temperature >= 25 && temperature <= 35 || summer == true && temperature >= 25 && temperature <= 45) {
			return true;	
        } else {                                    // Make only 1 if statement but with multiple conditions
			return false;                           // because multiple if statements could make dead code and
		}                                           // lead to not enough return statements for each if statements
    }
}