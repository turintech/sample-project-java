package run.java;
import java.util.ArrayList;

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
        // Using ArrayList instead of Vector for better performance since synchronization is not needed
        ArrayList<Integer> inputVec = new ArrayList<>(GenVector.generateVector(10, 10));
        ArrayList<Integer> inputVec2 = new ArrayList<>(GenVector.generateVector(10, 10));

        System.out.println("Vector");
        System.out.println("------");
        System.out.println(
                String.format("ModifyVector(%s): %s", inputVec.toString(),
                        DsVector.modifyVector(new Vector<>(inputVec)).toString()));
        System.out.println(String.format("SearchVector(%s, 5): %s",
                inputVec.toString(),
                DsVector.searchVector(new Vector<>(inputVec), 5)));
        System.out.println(String.format("SortVector(%s): %s", inputVec.toString(),
                DsVector.sortVector(new Vector<>(inputVec)).toString()));
        System.out.println(
                String.format("ReverseVector(%s): %s", inputVec.toString(),
                        DsVector.reverseVector(new Vector<>(inputVec)).toString()));
        System.out.println(
                String.format("RotateVector(%s, 3): %s", inputVec.toString(),
                        DsVector.rotateVector(new Vector<>(inputVec), 3).toString()));
        System.out.println(String.format(
                "MergeVectors(%s, %s): %s", inputVec.toString(), inputVec2.toString(),
                DsVector.mergeVectors(new Vector<>(inputVec), new Vector<>(inputVec2)).toString()));

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
        ArrayList<Integer> initialVec = new ArrayList<>(GenVector.generateVector(20, 10));
        System.out.println("Sort");
        System.out.println("------");
        Vector<Integer> inputVec0 = new Vector<>(initialVec);
        Sort.SortVector(inputVec0);
        System.out.println(String.format(
                "SortVector(%s): %s", initialVec.toString(), inputVec0.toString()));
        Vector<Integer> inputVec1 = new Vector<>(initialVec);
        Sort.DutchFlagPartition(inputVec1, 5);
        System.out.println(String.format("DutchFlagPartition(%s, 5): %s",
                inputVec1.toString(),
                inputVec1.toString()));
        System.out.println(String.format("MaxN(%s, 5): %s", initialVec.toString(),
                Sort.MaxN(new Vector<>(initialVec), 5).toString()));
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