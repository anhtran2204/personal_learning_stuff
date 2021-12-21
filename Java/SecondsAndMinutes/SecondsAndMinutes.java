public class SecondsAndMinutes {
    public static void main(String[] args) {
        getDurationString(60, 61);
        getDurationString(3601);
        System.out.println(getDurationString(60L, 61L));;                
    }

    public static int getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || (seconds < 0)) {
            System.out.println("Invalid value");
            return -1;
        }   
            int hours = minutes / 60;
            int remainingSeconds = seconds % 60;
            int remainingMinutes = minutes % 60;
            System.out.println(hours + " hr(s) " + remainingMinutes + " min(s) " + remainingSeconds + " sec(s)");
            return hours;
    } 

    public static int getDurationString(int seconds) {
        if (seconds < 0) {
            System.out.println("Invalid value");
            return -1;
        }
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int remainingSeconds = seconds % 60;
        int remainingMinutes = minutes % 60;
        System.out.println(seconds + " sec(s) is equal to " + hours + " hr(s) " + remainingMinutes + " min(s) and " + remainingSeconds + " sec(s)");
        return getDurationString(minutes, remainingSeconds);
    }    

    public static String getDurationString(long minutes, long seconds) {
        if ((minutes < 0) || (seconds < 0)) {
            return "Invalid value";
        }
            long hours = minutes / 60;                      // Because we're using the long data type,
            long remainingMinutes = minutes % 60;           // we have to cast L in our input in the main method
            long remainingSeconds = seconds % 60;
            
            String hourString = hours + "h";
            if (hours < 10) {
                hourString = "0" + hourString;
            }

            String minuteString = remainingMinutes + "m";
            if (minutes < 10) {
                minuteString = "0" + minuteString;
            }

            String secondString = remainingSeconds + "s";
            if (seconds < 10) {
                secondString = "0" + secondString;
            }

            return hourString + " " + minuteString + " " + secondString;
    }
}