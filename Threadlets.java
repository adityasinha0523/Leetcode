import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;
public class Threadlets {
    
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            
            if(canMakeEqualThreadlets(a, b, c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean canMakeEqualThreadlets(long a, long b, long c) {
        long total = a + b + c;
        if(a==b && b==c && c==a){
            return true;
        }
        if(total % 4 == 0) {
            long each = total / 4;
            if ((a + b + c - Math.max(a, Math.max(b, c)) <= 3 * each)||
            (a <= each && b <= each && c <= each)) return true;
        }
        
        if(total % 5 == 0) {
            long each = total / 5;
            if ((a <= each && b + c <= 3 * each) ||
                (b <= each && a + c <= 3 * each) ||
                (c <= each && a + b <= 3 * each)) return true;
        }
    
        if(total % 6 == 0) {
            long each = total / 6;
            if ((a <= 2 * each && b <= 2 * each && c <= 2 * each) ||
                (a <= 3 * each && b <= 2 * each && c <= each) ||
                (a <= 3 * each && b <= each && c <= 2 * each) ||
                (a <= each && b <= 3 * each && c <= 2 * each) ||
                (a <= each && b <= 2 * each && c <= 3 * each) ||
                (a <= 2 * each && b <= 3 * each && c <= each) ||
                (a <= 2 * each && b <= each && c <= 3 * each)) return true;
        }        
        
        return false;
    }        
}
