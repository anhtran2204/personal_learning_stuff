public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(22, 23, 34));
        System.out.println(isValid(1051));
    }

    public static boolean hasSameLastDigit(int x, int y, int z) {
        if ((x < 10 || x > 1000) || (y < 10 || y > 1000) || ( z < 10 || z > 1000)) {
            return false;
        }

        int lastX = 0;
        int lastY = 0;
        int lastZ = 0;

        while (x >= 10) {
            lastX = x % 10;
            while (y >= 10) {
                lastY = y % 10;
                while (z >= 10) {
                    lastZ = z % 10;
                    if ((lastX == lastY) || (lastY == lastZ) || (lastX == lastZ)) {
                        return true;
                    } 
                    z /= 10;
                } 
                y /= 10;
            } 
            x /= 10;
        } return false;
    }

    public static boolean isValid(int number) {
        if (number < 10 || number > 1000) {
            return false;
        } return true;
    }
}