package com.kepler76.algo;

import java.util.Arrays;
import java.util.stream.IntStream;


public class PrimeGenerator {

    public static int[] getAllPrimes(int bound) {
        return IntStream.range(0, bound).filter(PrimeGenerator :: isPrime).toArray();

    }

    public static boolean isPrime(int no) {
        if(no ==0 || no ==1) return false;
        for(int counter =2; counter <= Math.sqrt(no); counter++) {
            if((no % counter) == 0) return false;
        }
        return true;
    }


    public static int[] getPrimesViaSieve(int no) {
        int[] sieveArray = createPrimeArray(no);
        removeNonPrimes(sieveArray);
        return Arrays.stream(sieveArray).filter(v -> (v > 0)).toArray();
    }

    private static void removeNonPrimes(int[] sieveArray) {
        for(int counter = 2; counter <= Math.sqrt(sieveArray.length); counter++) {
            if(sieveArray[counter] > 0) {
                int nonPrimeIndex = counter*2;
                while(nonPrimeIndex <= sieveArray.length) {
                    sieveArray[nonPrimeIndex] = 0;
                    nonPrimeIndex += counter;
                }
            }
        }
    }

    private static int[] createPrimeArray(int no) {
        int[] sieveArray = new int[no +1];
        sieveArray[0] = 0;
        sieveArray[1] = 0;

        for(int counter = 2; counter <= no; counter++) {
            sieveArray[counter] = counter;
        }
        return sieveArray;
    }
}
