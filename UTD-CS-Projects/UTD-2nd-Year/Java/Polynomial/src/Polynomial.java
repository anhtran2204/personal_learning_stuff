package Polynomial.src;

import java.util.*;

public class Polynomial {
    private int coefficients[];

    public Polynomial(int array[]) {
        coefficients = new int [array.length];
        System.arraycopy(array, 0, coefficients, 0, array.length);
        this.trim();
    }

    public Polynomial(String line) {
        String pieces[] = line.split(" ");
        coefficients = new int [pieces.length];
        for(int i=0; i<pieces.length; i++)
            coefficients[pieces.length-1 - i] =  Integer.parseInt(pieces[i]);
        this.trim();
    }

    public Polynomial add(Polynomial second) {
        //we should add this object and second object 
        // add this.coefficients[] second.coefficients[] --> temp[]
        int temp[] = new int [Math.max(this.coefficients.length, second.coefficients.length)];

        System.arraycopy(this.coefficients, 0, temp, 0, this.coefficients.length);

        for(int i=0; i<second.coefficients.length; i++)
            temp[i] += second.coefficients[i];

        Polynomial p = new Polynomial(temp);
        p.trim();
        return p;
    }

    public Polynomial multiply(Polynomial second) {
        int length1 = this.coefficients.length;
        int length2 = second.coefficients.length;
        int temp[] = new int [length1 + length2 - 1];

        for(int i=0; i<length1; i++)
            for(int j=0; j<length2; j++)
                temp[i+j] += this.coefficients[i] * second.coefficients[j];

        Polynomial p = new Polynomial(temp);
        p.trim();
        return p;
    }

    public String toString() {
        String result = "";
        for(int i=this.coefficients.length-1; i>=0; i--)
            result += this.coefficients[i] + " ";
        return result;
    }

    private void trim() {
        if (coefficients.length == 1)
            return;

        int i = coefficients.length-1;
        while (i > 0 && coefficients[i] == 0)
            i--;

        if (i == coefficients.length-1)
            return;

        this.coefficients = Arrays.copyOf(coefficients, i+1);
    }

    public Polynomial derivative() {
        int[] temp = new int [this.coefficients.length];

        for(int i=0; i<this.coefficients.length; i++) {
            temp[i] = i * coefficients[i];
        }

        Polynomial p = new Polynomial(temp);
        p.trim();
        return p;
    }

    public static void main(String[] args) {
        Polynomial p = new Polynomial("1 5 -4 7 -2");
        Polynomial p2 = new Polynomial("1 5 -4 7 -2");
        Polynomial p3 = new Polynomial("1 2 3 0");
        System.out.println(p3);
        System.out.println(p.add(p2));
        System.out.println(p.derivative());
    }
}