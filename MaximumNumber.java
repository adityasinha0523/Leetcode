import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;
public class MaximumNumber {
    public long findMaximumNumber(long k, int x) {
        long left = 1, right = k * x + 1; // Estimating the upper bound
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (sumOfPrices(mid, x) > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private long sumOfPrices(long num, int x) {
        long sum = 0;
        for (int i = 1; i <= 64; i++) {
            if (i % x == 0) {
                sum += countSetBits(num, i);
            }
        }
        return sum;
    }

    // Count how many times the i-th bit is set in numbers from 1 to num
    private long countSetBits(long num, int i) {
        long total = num >> i; // Total number of complete cycles
        long remainder = num & ((1L << i) - 1); // Partial cycle
        return total + (remainder >= (1L << (i - 1)) ? 1 : 0);
    }

    public static void main(String[] args) {
        MaximumNumber solution = new MaximumNumber();
        //System.out.println(solution.findMaximumNumber(11, 27)); // Testing with the provided case
        System.out.println(solution.findMaximumNumber(9, 1)); // Output: 6
        System.out.println(solution.findMaximumNumber(7, 2)); // Output: 9
    }
}


