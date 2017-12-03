package com.kepler76.algo;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    @Benchmark
    public void standardPrimeProfiler() {
        PrimeGenerator.getAllPrimes(1000000);
    }

    @Benchmark
    public void sievePrimeProfiler() {
        PrimeGenerator.getPrimesViaSieve(1000000);
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