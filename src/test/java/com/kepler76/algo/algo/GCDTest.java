package com.kepler76.algo.algo;


import com.kepler76.algo.GCD;
import org.junit.Assert;
import org.junit.Test;

public class GCDTest {

    @Test
    public void testGCD() {
        Assert.assertEquals(6, GCD.gcd(12, 6));
        Assert.assertEquals(6, GCD.gcd(6, 12));
        Assert.assertEquals(1, GCD.gcd(3, 4));
        Assert.assertEquals(0, GCD.gcd(0, 0));


    }

}
