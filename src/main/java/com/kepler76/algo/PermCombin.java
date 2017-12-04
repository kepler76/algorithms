package com.kepler76.algo;

import java.util.LinkedList;
import java.util.List;

public class PermCombin {


    public static List<String> permutations(String str, int groupSize) {
        LinkedList<String> l = new LinkedList<>();
        permutations("", str, l, groupSize);
        return l;
    }

    public static List<String> permutations(String str) {
        return permutations(str, str.length());
    }


    private static void permutations(String temp, String str, List<String> permStrings, int groupSize) {
        if(temp.length() == groupSize) {
            permStrings.add(temp);
            return;
        }

        for(int charIndex = 0; charIndex < str.length(); charIndex++) {
            StringBuilder build = new StringBuilder(str);
            build.deleteCharAt(charIndex);
            permutations(temp + str.charAt(charIndex), build.toString(), permStrings, groupSize);
        }

    }

    public static List<String> combinations(String str, int groupSize) {
        LinkedList<String> l = new LinkedList<>();
        combinations("", str, l, groupSize);
        return l;
    }

    public static List<String> combinations(String str) {
        return combinations(str, str.length());
    }

    private static void combinations(String temp, String str, List<String> permStrings, int groupSize) {
        if(temp.length() == groupSize) {
            permStrings.add(temp);
            return;
        }

        for(int charIndex = 0; charIndex < str.length(); charIndex++) {
            combinations(temp + str.charAt(charIndex), str.substring(charIndex+1), permStrings, groupSize);
        }

    }


    public static void main(String[] args) {
        System.out.println(PermCombin.combinations("1234",3));
        System.out.println(PermCombin.permutations("1234",3));

    }

}
