package com.kepler76.algo;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BenchmarkRunner {

    static int genArray[];
    static final int NO_OF_ELEMENTS = 100;


    public BenchmarkRunner() {
        Random genRandom = new Random();
        genArray = IntStream.range(0,NO_OF_ELEMENTS).map(v -> genRandom.nextInt()).toArray();
    }

    @Benchmark
    public void bubbleSortPTest() {
        int[] unSortedArray = genArray.clone();
        Sorting.bubblesort(unSortedArray);
    }

    @Benchmark
    public void insertionSortPTest() {
        int[] unSortedArray = genArray.clone();
        Sorting.insertionSort(unSortedArray);
    }

    @Benchmark
    public void selectionSortPTest() {
        int[] unSortedArray = genArray.clone();
        Sorting.insertionSort(unSortedArray);
    }

    @Benchmark
    public void mergeSortPTest() {
        List<Integer> unSortedList = Arrays.stream(genArray.clone()).boxed().collect(Collectors.toList());
        Sorting.mergeSort(unSortedList);
    }


    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .mode(Mode.Throughput) //Calculate number of operations in a time unit.
                .mode(Mode.AverageTime) //Calculate an average running time per operation
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupIterations(1)
                .measurementIterations(5)
                .threads(Runtime.getRuntime().availableProcessors())
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }
}