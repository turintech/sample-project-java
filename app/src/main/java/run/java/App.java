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
        System.out.printf("SumRange(10): %s%n", Single.sumRange(10));
        System.out.printf("MaxArray([1, 2, 3, 4, 5]): %s%n", Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
        System.out.printf("SumModulus(100, 3): %s%n", Single.sumModulus(100, 3));
        System.out.println();
    }

    public static void double_() {
        System.out.println("DoubleForLoop");
        System.out.println("-------------");
        System.out.printf("SumSquare(10): %s%n", Double.sumSquare(10));
        System.out.printf("SumTriangle(10): %s%n", Double.sumTriangle(10));
        System.out.printf("CountPairs([1, 2, 3, 4, 5]): %s%n", Double.countPairs(new int[] { 1, 2, 3, 4, 5, 2 }));
        System.out.printf("CountDuplicates([1, 2, 3, 4, 5], [1, 3, 2, 4, 5]): %s%n", Double.countDuplicates(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 2, 4, 5 }));
        System.out.println();
    }

    public static void vector() {
        Vector<Integer> inputVec = GenVector.generateVector(10, 10);
        Vector<Integer> inputVec2 = GenVector.generateVector(10, 10);

        System.out.println("Vector");
        System.out.println("------");
        System.out.printf("ModifyVector(%s): %s%n", inputVec, DsVector.modifyVector(inputVec));
        System.out.printf("SearchVector(%s, 5): %s%n", inputVec, DsVector.searchVector(inputVec, 5));
        System.out.printf("SortVector(%s): %s%n", inputVec, DsVector.sortVector(inputVec));
        System.out.printf("ReverseVector(%s): %s%n", inputVec, DsVector.reverseVector(inputVec));
        System.out.printf("RotateVector(%s, 3): %s%n", inputVec, DsVector.rotateVector(inputVec, 3));
        System.out.printf("MergeVectors(%s, %s): %s%n", inputVec, inputVec2, DsVector.mergeVectors(inputVec, inputVec2));

        System.out.println();
    }

    public static void primes() {
        System.out.println("Primes");
        System.out.println("------");
        System.out.printf("IsPrime(10): %s%n", Primes.IsPrime(10));
        System.out.printf("SumPrimes(10): %s%n", Primes.SumPrimes(10));
        System.out.printf("PrimeFactors(10): %s%n", Primes.PrimeFactors(10));
        System.out.println();
    }

    public static void sort() {
        Vector<Integer> initialVec = GenVector.generateVector(20, 10);
        System.out.println("Sort");
        System.out.println("------");
        Vector<Integer> inputVec0 = new Vector<>(initialVec);
        Sort.SortVector(inputVec0);
        System.out.printf("SortVector(%s): %s%n", initialVec, inputVec0);
        Vector<Integer> inputVec1 = new Vector<>(initialVec);
        Sort.DutchFlagPartition(inputVec1, 5);
        System.out.printf("DutchFlagPartition(%s, 5): %s%n", inputVec1, inputVec1);
        System.out.printf("MaxN(%s, 5): %s%n", initialVec, Sort.MaxN(initialVec, 5));
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