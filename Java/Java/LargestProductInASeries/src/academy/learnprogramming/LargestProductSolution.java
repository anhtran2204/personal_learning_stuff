package academy.learnprogramming;

import java.math.BigInteger;

public class LargestProductSolution {
    public static void main(String[] args) {
        String values = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";

        System.out.println(product(values, 13));
    }

    // This is the BigInteger method
    private static BigInteger product(String values, final int adjDigit) {
        long startTime = System.nanoTime();

        // the var is used to declare variables w/out worrying about the type
        // the BigInteger.ZERO, .ONE are used to call constant
        var max = BigInteger.ZERO;
        for (var x = 0; x + adjDigit < values.length(); x++) {
            var product = BigInteger.ONE;
            String sub = values.substring(x, x + adjDigit);
            for (var j = 0; j < sub.length(); j++) {
                // we do this if statement to cross out the operations that have 0s in it
                // because multiplying w/ zeros is = 0 so it's redundant
                // this will make the program faster
                if (Character.getNumericValue(sub.charAt(j)) == 0) {
                    break;
                }
                // the .multiply is used to multiply given a val(value) in the brackets
                // in this case is the numeric value of a char that was turn into a BigInteger data type
                product = product.multiply(BigInteger.valueOf(Character.getNumericValue(sub.charAt(j))));

                // the .max is used to compare the product and max and find the greater value
                max = max.max(product);
            }
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Runtime is: " + totalTime);
        return max;
    }
}
