package benchmark;

import algorithms.Sort;
import control.Double;
import control.Single;
import datastructures.DsVector;
import generator.GenVector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Benchmark {

    private static final int WARMUP_ITERATIONS = 50;
    private static final int MEASURE_ITERATIONS = 200;

    static class Result {
        String operation;
        double throughput;
        double latencyP50;
        double latencyP99;

        Result(String operation, double throughput, double latencyP50, double latencyP99) {
            this.operation = operation;
            this.throughput = throughput;
            this.latencyP50 = latencyP50;
            this.latencyP99 = latencyP99;
        }
    }

    private static long[] measureLatencies(Runnable task) {
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            task.run();
        }

        long[] latencies = new long[MEASURE_ITERATIONS];
        for (int i = 0; i < MEASURE_ITERATIONS; i++) {
            long start = System.nanoTime();
            task.run();
            latencies[i] = System.nanoTime() - start;
        }
        return latencies;
    }

    private static Result record(String operation, Runnable task) {
        long[] latencies = measureLatencies(task);
        Arrays.sort(latencies);

        double latencyP50Us = latencies[(int) (MEASURE_ITERATIONS * 0.50)] / 1000.0;
        double latencyP99Us = latencies[(int) (MEASURE_ITERATIONS * 0.99)] / 1000.0;

        long totalNanos = 0;
        for (long l : latencies) {
            totalNanos += l;
        }
        double totalSeconds = totalNanos / 1_000_000_000.0;
        double throughput = MEASURE_ITERATIONS / totalSeconds;

        return new Result(operation, throughput, latencyP50Us, latencyP99Us);
    }

    public static void run() throws IOException {
        List<Result> results = new ArrayList<>();

        int[] largeArr = new int[10_000];
        for (int i = 0; i < largeArr.length; i++) largeArr[i] = i;

        int[] pairsArr = new int[1_000];
        for (int i = 0; i < pairsArr.length; i++) pairsArr[i] = i % 50;

        Vector<Integer> searchVec = GenVector.generateVector(10_000, 1_000);

        results.add(record("sumRange", () -> Single.sumRange(10_000)));
        results.add(record("maxArray", () -> Single.maxArray(largeArr)));
        results.add(record("sumModulus", () -> Single.sumModulus(10_000, 3)));
        results.add(record("sumSquare", () -> Double.sumSquare(500)));
        results.add(record("countPairs", () -> Double.countPairs(pairsArr)));
        results.add(record("sortVector", () -> {
            Vector<Integer> v = GenVector.generateVector(1_000, 1_000);
            DsVector.sortVector(v);
        }));
        results.add(record("dutchFlagPartition", () -> {
            Vector<Integer> v = GenVector.generateVector(5_000, 1_000);
            Sort.DutchFlagPartition(v, 500);
        }));
        results.add(record("searchVector", () -> DsVector.searchVector(searchVec, 500)));

        writeResults(results);
    }

    private static void writeResults(List<Result> results) throws IOException {
        // Write CSV
        try (PrintWriter csv = new PrintWriter(new FileWriter("artemis_results.csv"))) {
            csv.println("throughput,latency_p50,latency_p99");
            for (Result r : results) {
                csv.printf("%.2f,%.2f,%.2f%n", r.throughput, r.latencyP50, r.latencyP99);
            }
        }

        // Write JSON
        try (PrintWriter json = new PrintWriter(new FileWriter("artemis_results.json"))) {
            json.println("[");
            for (int i = 0; i < results.size(); i++) {
                Result r = results.get(i);
                json.printf("  {\"throughput\": %.2f, \"latency_p50\": %.2f, \"latency_p99\": %.2f}",
                        r.throughput, r.latencyP50, r.latencyP99);
                if (i < results.size() - 1) json.println(",");
                else json.println();
            }
            json.println("]");
        }

        System.out.println("Artemis results written to artemis_results.csv and artemis_results.json");
        System.out.println();

        // Log CSV contents
        System.out.println("=== artemis_results.csv ===");
        System.out.println("throughput,latency_p50,latency_p99");
        for (Result r : results) {
            System.out.printf("%.2f,%.2f,%.2f%n", r.throughput, r.latencyP50, r.latencyP99);
        }
        System.out.println();

        // Log JSON contents
        System.out.println("=== artemis_results.json ===");
        System.out.println("[");
        for (int i = 0; i < results.size(); i++) {
            Result r = results.get(i);
            System.out.printf("  {\"throughput\": %.2f, \"latency_p50\": %.2f, \"latency_p99\": %.2f}",
                    r.throughput, r.latencyP50, r.latencyP99);
            if (i < results.size() - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("]");
    }
}
