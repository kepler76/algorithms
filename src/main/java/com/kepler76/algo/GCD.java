package com.kepler76.algo;


public class GCD {
    // Adding a comment
    public static int gcd(int x, int y) {
        if(y  == 0) return x;
        return gcd(y, x % y);
    }

}
