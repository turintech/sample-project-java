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

        System.out.println("Vector");
        System.out.println("------");
        System.out.println(
                String.format("ModifyVector(%s): %s", inputVec.toString(),
                        DsVector.modifyVector(inputVec).toString()));
        System.out.println(String.format("SearchVector(%s, 5): %s",
                inputVec.toString(),
                DsVector.searchVector(inputVec, 5)));
        System.out.println(String.format("SortVector(%s): %s", inputVec.toString(),
                DsVector.sortVector(inputVec).toString()));
        System.out.println(
                String.format("ReverseVector(%s): %s", inputVec.toString(),
                        DsVector.reverseVector(inputVec).toString()));
        System.out.println(
                String.format("RotateVector(%s, 3): %s", inputVec.toString(),
                        DsVector.rotateVector(inputVec, 3).toString()));
        System.out.println(String.format(
                "MergeVectors(%s, %s): %s", inputVec.toString(), inputVec2.toString(),
                DsVector.mergeVectors(inputVec, inputVec2).toString()));

        System.out.println();
    }

    public static void primes() {
        System.out.println("Primes");
        System.out.println("------");
        
        // Test isPrime with various cases
        System.out.println(String.format("isPrime(2): %s (smallest prime)", 
                Primes.isPrime(2)));
        System.out.println(String.format("isPrime(10): %s (composite)", 
                Primes.isPrime(10)));
        System.out.println(String.format("isPrime(17): %s (prime)", 
                Primes.isPrime(17)));
        System.out.println(String.format("isPrime(1): %s (not prime)", 
                Primes.isPrime(1)));
        
        // Test sumPrimes with meaningful values
        System.out.println(String.format("sumPrimes(10): %s (2+3+5+7)", 
                Primes.sumPrimes(10)));
        System.out.println(String.format("sumPrimes(100): %s", 
                Primes.sumPrimes(100)));
        
        // Test primeFactors with various numbers
        System.out.println(String.format("primeFactors(10): %s (2×5)",
                Primes.primeFactors(10).toString()));
        System.out.println(String.format("primeFactors(12): %s (2²×3)",
                Primes.primeFactors(12).toString()));
        System.out.println(String.format("primeFactors(17): %s (prime)",
                Primes.primeFactors(17).toString()));
        
        System.out.println();
    }

    public static void sort() {
        Vector<Integer> initialVec = GenVector.generateVector(20, 10);
        System.out.println("Sort");
        System.out.println("------");
        Vector<Integer> inputVec0 = new Vector<Integer>(initialVec);
        Sort.SortVector(inputVec0);
        System.out.println(String.format(
                "SortVector(%s): %s", initialVec.toString(), inputVec0.toString()));
        Vector<Integer> inputVec1 = new Vector<Integer>(initialVec);
        Sort.DutchFlagPartition(inputVec1, 5);
        System.out.println(String.format("DutchFlagPartition(%s, 5): %s",
                inputVec1.toString(),
                inputVec1.toString()));
        System.out.println(String.format("MaxN(%s, 5): %s", initialVec.toString(),
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
