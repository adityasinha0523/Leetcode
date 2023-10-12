import java.util.Scanner;
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

public class SubstringOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String x = sc.next();
            String s = sc.next();
            if(hasAllChars(x, s)){
                System.out.println(minOperations(x, s));
            }else{
                System.out.println("-1");
            }
        }
        sc.close();
    }

    private static boolean hasAllChars(String x, String s) {
        for (char c : s.toCharArray()) {
            if (!x.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    private static int minOperations(String x, String s) {
        int operations = 0;
        //String initialX = x;
        while (operations <= 10) {
            if (x.contains(s)) {
                return operations;
            }
            x += x;
            operations++;
        }
        return -1;
    }
}
