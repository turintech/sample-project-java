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
        run("csv");
    }

    public static void run(String format) throws IOException {
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

        writeResults(results, format);
    }

    private static void writeResults(List<Result> results, String format) throws IOException {
        // Build header and values: one row per execution, columns = operation_metric
        StringBuilder header = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (int i = 0; i < results.size(); i++) {
            Result r = results.get(i);
            if (i > 0) {
                header.append(",");
                values.append(",");
            }
            header.append(r.operation).append("_throughput,");
            header.append(r.operation).append("_latency_p50,");
            header.append(r.operation).append("_latency_p99");
            values.append(String.format("%.2f,%.2f,%.2f", r.throughput, r.latencyP50, r.latencyP99));
        }

        String filename = "artemis_results." + format;

        if ("json".equals(format)) {
            try (PrintWriter json = new PrintWriter(new FileWriter(filename))) {
                json.println("[");
                json.print("  {");
                for (int i = 0; i < results.size(); i++) {
                    Result r = results.get(i);
                    if (i > 0) json.print(", ");
                    json.printf("\"%s_throughput\": %.2f, \"%s_latency_p50\": %.2f, \"%s_latency_p99\": %.2f",
                            r.operation, r.throughput, r.operation, r.latencyP50, r.operation, r.latencyP99);
                }
                json.println("}");
                json.println("]");
            }

            System.out.println("Artemis results written to " + filename);
            System.out.println();
            System.out.println("=== " + filename + " ===");
            System.out.println("[");
            System.out.print("  {");
            for (int i = 0; i < results.size(); i++) {
                Result r = results.get(i);
                if (i > 0) System.out.print(", ");
                System.out.printf("\"%s_throughput\": %.2f, \"%s_latency_p50\": %.2f, \"%s_latency_p99\": %.2f",
                        r.operation, r.throughput, r.operation, r.latencyP50, r.operation, r.latencyP99);
            }
            System.out.println("}");
            System.out.println("]");
        } else {
            try (PrintWriter csv = new PrintWriter(new FileWriter(filename))) {
                csv.println(header);
                csv.println(values);
            }

            System.out.println("Artemis results written to " + filename);
            System.out.println();
            System.out.println("=== " + filename + " ===");
            System.out.println(header);
            System.out.println(values);
        }
    }
}
