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

class problem2999{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        long sol=numberOfPowerfulInt(1000,2000,4,"3000");
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long count = 0;

        // Generate numbers starting from the suffix and going up, checking if they're within the range
        for (long num = Long.parseLong(s); num <= finish; num = getNextNumber(num, limit, s.length())) {
            if (num >= start) {
                count++;
            }
        }

        return count;
    }

    private static long getNextNumber(long current, int limit, int suffixLength) {
        long base = (long) Math.pow(10, suffixLength);
        long prefix = current / base; // Get the part of the number before the suffix

        // Increase the prefix until a digit exceeds the limit or we reach a new number with the same suffix
        while (true) {
            prefix++;
            if (isWithinLimit(prefix, limit)) {
                return prefix * base + current % base;
            }
        }
    }

    private static boolean isWithinLimit(long num, int limit) {
        while (num > 0) {
            if (num % 10 > limit) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}  