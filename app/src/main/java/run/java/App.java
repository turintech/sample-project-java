package run.java;

import algorithms.Primes;
import algorithms.Sort;
import control.Double;
import control.Single;
import datastructures.DsVector;
import generator.GenVector;
import java.util.Vector;

public class App {
    private static final String FORMAT_STRING = "%s: %s";

    public static void single() {
        System.out.println("SingleForLoop");
        System.out.println("-------------");
        System.out.printf(FORMAT_STRING + "%n", "SumRange(10)", Single.sumRange(10));
        System.out.printf(FORMAT_STRING + "%n", "MaxArray([1, 2, 3, 4, 5])",
                Single.maxArray(new int[] { 1, 2, 3, 4, 5 }));
        System.out.printf(FORMAT_STRING + "%n%n", "SumModulus(100, 3)", Single.sumModulus(100, 3));
    }

    public static void double_() {
        System.out.println("DoubleForLoop");
        System.out.println("-------------");
        System.out.printf(FORMAT_STRING + "%n", "SumSquare(10)", Double.sumSquare(10));
        System.out.printf(FORMAT_STRING + "%n", "SumTriangle(10)", Double.sumTriangle(10));
        System.out.printf(FORMAT_STRING + "%n", "CountPairs([1, 2, 3, 4, 5, 2])",
                Double.countPairs(new int[] { 1, 2, 3, 4, 5, 2 }));
        System.out.printf(FORMAT_STRING + "%n%n", "CountDuplicates([1, 2, 3, 4, 5], [1, 3, 2, 4, 5])",
                Double.countDuplicates(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 2, 4, 5 }));
    }

    public static void vector() {
        Vector<Integer> inputVec = GenVector.generateVector(10, 10);
        Vector<Integer> inputVec2 = GenVector.generateVector(10, 10);

        System.out.println("Vector");
        System.out.println("------");
        System.out.printf(FORMAT_STRING + "%n", "ModifyVector(" + inputVec + ")",
                DsVector.modifyVector(inputVec));
        System.out.printf(FORMAT_STRING + "%n", "SearchVector(" + inputVec + ", 5)",
                DsVector.searchVector(inputVec, 5));
        System.out.printf(FORMAT_STRING + "%n", "SortVector(" + inputVec + ")",
                DsVector.sortVector(inputVec));
        System.out.printf(FORMAT_STRING + "%n", "ReverseVector(" + inputVec + ")",
                DsVector.reverseVector(inputVec));
        System.out.printf(FORMAT_STRING + "%n", "RotateVector(" + inputVec + ", 3)",
                DsVector.rotateVector(inputVec, 3));
        System.out.printf(FORMAT_STRING + "%n%n", "MergeVectors(" + inputVec + ", " + inputVec2 + ")",
                DsVector.mergeVectors(inputVec, inputVec2));
    }

    public static void primes() {
        System.out.println("Primes");
        System.out.println("------");
        System.out.printf(FORMAT_STRING + "%n", "IsPrime(10)", Primes.IsPrime(10));
        System.out.printf(FORMAT_STRING + "%n", "SumPrimes(10)", Primes.SumPrimes(10));
        System.out.printf(FORMAT_STRING + "%n%n", "PrimeFactors(10)", Primes.PrimeFactors(10));
    }

    public static void sort() {
        Vector<Integer> initialVec = GenVector.generateVector(20, 10);
        System.out.println("Sort");
        System.out.println("------");
        Vector<Integer> inputVec0 = new Vector<>(initialVec);
        Sort.SortVector(inputVec0);
        System.out.printf(FORMAT_STRING + "%n", "SortVector(" + initialVec + ")", inputVec0);
        Vector<Integer> inputVec1 = new Vector<>(initialVec);
        Sort.DutchFlagPartition(inputVec1, 5);
        System.out.printf(FORMAT_STRING + "%n", "DutchFlagPartition(" + initialVec + ", 5)", inputVec1);
        System.out.printf(FORMAT_STRING + "%n%n", "MaxN(" + initialVec + ", 5)", Sort.MaxN(initialVec, 5));
    }

    public static void main(String[] args) {
        single();
        double_();
        vector();
        primes();
        sort();
    }
}