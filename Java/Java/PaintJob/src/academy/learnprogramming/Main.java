package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBucketCount(3.4,2.1,1.5,2));
        System.out.println(getBucketCount(3.4,2.1,1.5));;
        System.out.println(getBucketCount(0.0,1.5));

    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        int buckets = (int) Math.ceil(((width * height)/areaPerBucket) - extraBuckets);
        return buckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        int buckets = (int) Math.ceil((width * height)/areaPerBucket);
        return buckets;
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        int buckets = (int) Math.ceil(area/areaPerBucket);
        return buckets;
    }
}
