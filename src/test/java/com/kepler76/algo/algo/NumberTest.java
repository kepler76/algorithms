package com.kepler76.algo.algo;


import com.kepler76.algo.GCD;
import com.kepler76.algo.PrimeGenerator;
import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    @Test
    public void testGCD() {
        Assert.assertEquals(6, GCD.gcd(12, 6));
        Assert.assertEquals(6, GCD.gcd(6, 12));
        Assert.assertEquals(1, GCD.gcd(3, 4));
        Assert.assertEquals(0, GCD.gcd(0, 0));
    }


    @Test
    public void testPrime() {
        Assert.assertTrue(PrimeGenerator.isPrime(5));
        Assert.assertFalse(PrimeGenerator.isPrime(1));

        Assert.assertArrayEquals(new int[] {2,3,5,7},
                PrimeGenerator.getAllPrimes(10));


        Assert.assertArrayEquals(PrimeGenerator.getAllPrimes(10),
                PrimeGenerator.getPrimesViaSieve(10));


        Assert.assertArrayEquals(PrimeGenerator.getAllPrimes(1000),
                PrimeGenerator.getPrimesViaSieve(1000));

    }

}
