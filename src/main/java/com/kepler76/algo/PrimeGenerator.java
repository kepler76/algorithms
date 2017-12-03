package com.kepler76.algo;

import java.util.Arrays;
import java.util.stream.IntStream;


public class PrimeGenerator {

    public static int[] getAllPrimes(int bound) {
        return IntStream.range(0, bound).filter(num -> isPrime(num)).toArray();

    }

    public static boolean isPrime(int no) {
        if(no ==0 || no ==1) return false;
        for(int counter =2; counter <= Math.sqrt(no); counter++) {
            if((no % counter) == 0) return false;
        }
        return true;
    }

    public static int[] getPrimesViaSieve(int no) {
        int[] sieveArray = new int[no +1];
        sieveArray[0] = 0;
        sieveArray[1] = 0;

        for(int counter = 2; counter <= no; counter++) {
            sieveArray[counter] = counter;
        }

        for(int counter = 2; counter <= no; counter++) {
            if(sieveArray[counter] > 0) {
                int multipleIndex = counter*2;
                while(multipleIndex <= no) {
                    sieveArray[multipleIndex] = 0;
                    multipleIndex += counter;
                }
            }
        }

        return Arrays.stream(sieveArray).filter(v -> (v > 0)).toArray();



    }

    public static void main(String[] args) {
        System.out.println("Start");
        int[] primes = PrimeGenerator.getPrimesViaSieve(80);
        System.out.println(Arrays.toString(primes));

        System.out.println("End");

    }
}
