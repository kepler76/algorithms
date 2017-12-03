package com.kepler76.algo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortTest {

    static int genArray[];
    static final int NO_OF_ELEMENTS = 100;

    @BeforeClass
    public static void setUpStandardArray() {
        Random genRandom = new Random();
        genArray = IntStream.range(0,NO_OF_ELEMENTS).map(v -> genRandom.nextInt()).toArray();
    }

    @Test
    public void bubbleSortTest() {
        int[] unSortedArray = genArray.clone();
        int[] sortedArray = genArray.clone();
        Arrays.sort(sortedArray);
        Assert.assertArrayEquals(sortedArray, Sorting.bubblesort(unSortedArray));
    }

    @Test
    public void insertionSortTest() {
        int[] unSortedArray = genArray.clone();
        int[] sortedArray = genArray.clone();
        Arrays.sort(sortedArray);
        Assert.assertArrayEquals(sortedArray, Sorting.insertionSort(unSortedArray));
    }

    @Test
    public void selectionSortTest() {
        int[] unSortedArray = genArray.clone();
        int[] sortedArray = genArray.clone();
        Arrays.sort(sortedArray);
        Assert.assertArrayEquals(sortedArray, Sorting.selectionSort(unSortedArray));
    }

    @Test
    public void mergeListTest() {

        List<Integer> l1 = Arrays.asList(1,3,5,6,9);
        List<Integer> l2 = Arrays.asList(2,3,4,5,10,12);
        List<Integer> combined = Arrays.asList(1,2,3,3,4,5,5,6,9,10,12);

        Assert.assertEquals(Sorting.merge(l1,l2), combined);

    }

    @Test
    public void mergeSortTest1() {
        List<Integer> unSortedList = Arrays.asList(5,4,3,2,1);
        List<Integer> sortedList =  Arrays.asList(5,4,3,2,1);
        Collections.sort(sortedList);
        Assert.assertEquals(sortedList, Sorting.mergeSort(unSortedList));
    }

    @Test
    public void mergeSortTest2() {
        List<Integer> unSortedList = Arrays.stream(genArray.clone()).boxed().collect(Collectors.toList());
        List<Integer> sortedList =  Arrays.stream(genArray.clone()).boxed().collect(Collectors.toList());
        Collections.sort(sortedList);
        Assert.assertEquals(sortedList, Sorting.mergeSort(unSortedList));
    }


}
