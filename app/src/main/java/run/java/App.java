package run.java;

import algorithms.Primes;
import algorithms.Sort;
import control.Double;
import control.Single;
import datastructures.DsVector;
import generator.GenVector;
import java.util.Vector;

public class App {
    private static final StringBuilder sb = new StringBuilder();
    
    public static void single() {
        sb.setLength(0);
        sb.append("SingleForLoop\n-------------\n");
        sb.append(String.format("SumRange(10): %s\n", Single.sumRange(10)));
        sb.append(String.format("MaxArray([1, 2, 3, 4, 5]): %s\n",
                Single.maxArray(new int[] { 1, 2, 3, 4, 5 })));
        sb.append(String.format("SumModulus(100, 3): %s\n", Single.sumModulus(100, 3)));
        sb.append('\n');
        System.out.print(sb.toString());
    }

    public static void double_() {
        sb.setLength(0);
        sb.append("DoubleForLoop\n-------------\n");
        sb.append(String.format("SumSquare(10): %s\n", Double.sumSquare(10)));
        sb.append(String.format("SumTriangle(10): %s\n", Double.sumTriangle(10)));
        sb.append(String.format("CountPairs([1, 2, 3, 4, 5]): %s\n",
                Double.countPairs(new int[] { 1, 2, 3, 4, 5, 2 })));
        sb.append(String.format("CountDuplicates([1, 2, 3, 4, 5], [1, 3, 2, 4, 5]): %s\n",
                Double.countDuplicates(new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 1, 3, 2, 4, 5 })));
        sb.append('\n');
        System.out.print(sb.toString());
    }

    public static void vector() {
        Vector<Integer> inputVec = GenVector.generateVector(10, 10);
        Vector<Integer> inputVec2 = GenVector.generateVector(10, 10);
        String inputVecStr = inputVec.toString();
        String inputVec2Str = inputVec2.toString();

        sb.setLength(0);
        sb.append("Vector\n------\n");
        sb.append(String.format("ModifyVector(%s): %s\n", inputVecStr,
                DsVector.modifyVector(inputVec).toString()));
        sb.append(String.format("SearchVector(%s, 5): %s\n",
                inputVecStr,
                DsVector.searchVector(inputVec, 5)));
        sb.append(String.format("SortVector(%s): %s\n", inputVecStr,
                DsVector.sortVector(inputVec).toString()));
        sb.append(String.format("ReverseVector(%s): %s\n", inputVecStr,
                DsVector.reverseVector(inputVec).toString()));
        sb.append(String.format("RotateVector(%s, 3): %s\n", inputVecStr,
                DsVector.rotateVector(inputVec, 3).toString()));
        sb.append(String.format("MergeVectors(%s, %s): %s\n", inputVecStr, inputVec2Str,
                DsVector.mergeVectors(inputVec, inputVec2).toString()));
        sb.append('\n');
        System.out.print(sb.toString());
    }

    public static void primes() {
        sb.setLength(0);
        sb.append("Primes\n------\n");
        sb.append(String.format("IsPrime(10): %s\n", Primes.IsPrime(10)));
        sb.append(String.format("SumPrimes(10): %s\n", Primes.SumPrimes(10)));
        sb.append(String.format("PrimeFactors(10): %s\n",
                Primes.PrimeFactors(10).toString()));
        sb.append('\n');
        System.out.print(sb.toString());
    }

    public static void sort() {
        Vector<Integer> initialVec = GenVector.generateVector(20, 10);
        String initialVecStr = initialVec.toString();
        
        sb.setLength(0);
        sb.append("Sort\n------\n");
        Vector<Integer> inputVec0 = new Vector<Integer>(initialVec);
        Sort.SortVector(inputVec0);
        sb.append(String.format("SortVector(%s): %s\n", initialVecStr, inputVec0.toString()));
        Vector<Integer> inputVec1 = new Vector<Integer>(initialVec);
        Sort.DutchFlagPartition(inputVec1, 5);
        sb.append(String.format("DutchFlagPartition(%s, 5): %s\n",
                initialVecStr,
                inputVec1.toString()));
        sb.append(String.format("MaxN(%s, 5): %s\n", initialVecStr,
                Sort.MaxN(initialVec, 5).toString()));
        sb.append('\n');
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        single();
        double_();
        vector();
        primes();
        sort();
    }
}