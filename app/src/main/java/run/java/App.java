package run.java;

import algorithms.Primes;
import algorithms.Sort;
import control.Double;
import control.Single;
import datastructures.DsVector;
import generator.GenVector;
import java.util.Vector;

public class App {
    public static void single() {
        System.out.println("SingleForLoop");
        System.out.println("-------------");
        System.out.println(String.format("SumRange(10): %s", Single.sumRange(10)));
        System.out.println(
                String.format("MaxArray([1, 2, 3, 4, 5]): %s",
                        Single.maxArray(new int[] { 1, 2, 3, 4, 5 })));
        System.out.println(
                String.format("SumModulus(100, 3): %s", Single.sumModulus(100, 3)));
        System.out.println();
    }

    public static void double_() {
        System.out.println("DoubleForLoop");
        System.out.println("-------------");
        System.out.println(
                String.format("SumSquare(10): %s", Double.sumSquare(10)));
        System.out.println(
                String.format("SumTriangle(10): %s", Double.sumTriangle(10)));
        System.out.println(
                String.format("CountPairs([1, 2, 3, 4, 5]): %s",
                        Double.countPairs(new int[] { 1, 2, 3, 4, 5, 2 })));
        System.out.println(
                String.format("CountDuplicates([1, 2, 3, 4, 5], [1, 3, 2, 4, 5]): %s",
                        Double.countDuplicates(new int[] { 1, 2, 3, 4, 5 },
                                new int[] { 1, 3, 2, 4, 5 })));
        System.out.println();
    }

    public static void vector() {
        Vector<Integer> inputVec = GenVector.generateVector(10, 10);
        Vector<Integer> inputVec2 = GenVector.generateVector(10, 10);
        final String inputVecStr = inputVec.toString();
        final String inputVec2Str = inputVec2.toString();

        System.out.println("Vector");
        System.out.println("------");
        System.out.println(
                String.format("ModifyVector(%s): %s", inputVecStr,
                        DsVector.modifyVector(inputVec).toString()));
        System.out.println(String.format("SearchVector(%s, 5): %s",
                inputVecStr,
                DsVector.searchVector(inputVec, 5)));
        System.out.println(String.format("SortVector(%s): %s", inputVecStr,
                DsVector.sortVector(inputVec).toString()));
        System.out.println(
                String.format("ReverseVector(%s): %s", inputVecStr,
                        DsVector.reverseVector(inputVec).toString()));
        System.out.println(
                String.format("RotateVector(%s, 3): %s", inputVecStr,
                        DsVector.rotateVector(inputVec, 3).toString()));
        System.out.println(String.format(
                "MergeVectors(%s, %s): %s", inputVecStr, inputVec2Str,
                DsVector.mergeVectors(inputVec, inputVec2).toString()));

        System.out.println();
    }

    public static void primes() {
        System.out.println("Primes");
        System.out.println("------");
        System.out.println(String.format("IsPrime(10): %s", Primes.IsPrime(10)));
        System.out.println(
                String.format("SumPrimes(10): %s", Primes.SumPrimes(10)));
        System.out.println(String.format("PrimeFactors(10): %s",
                Primes.PrimeFactors(10).toString()));
        System.out.println();
    }

    public static void sort() {
        Vector<Integer> initialVec = GenVector.generateVector(20, 10);
        System.out.println("Sort");
        System.out.println("------");
        final String initialVecStr = initialVec.toString();
        final Vector<Integer> workingVec = new Vector<>(initialVec);
        Sort.SortVector(workingVec);
        System.out.println(String.format(
                "SortVector(%s): %s", initialVecStr, workingVec.toString()));

        workingVec.clear();
        workingVec.addAll(initialVec);
        Sort.DutchFlagPartition(workingVec, 5);
        System.out.println(String.format("DutchFlagPartition(%s, 5): %s",
                initialVecStr,
                workingVec.toString()));
        System.out.println(String.format("MaxN(%s, 5): %s", initialVecStr,
                Sort.MaxN(initialVec, 5).toString()));
        System.out.println();
    }

    public static void main(String[] args) {
        single();
        double_();
        vector();
        primes();
        sort();
    }
}