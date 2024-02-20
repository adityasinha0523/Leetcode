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
import java.io.StreamCorruptedException;
import java.util.*;
import java.lang.*;

class WC385P2{
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
        int[] num1=new int[2];
        for (int i = 0; i < num1.length; i++) {
            num1[i]=scan.nextInt();
        }

        int[] num2=new int[2];
        for (int i = 0; i < num2.length; i++) {
            num2[i]=scan.nextInt();
        }
        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=longestCommonPrefix(num1,num2);
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

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> prefixes = new HashMap<>();
        for (int num : arr1) {
            String str = Integer.toString(num);
            for (int i = 1; i <= str.length(); ++i) {
                String prefix = str.substring(0, i);
                prefixes.put(prefix, prefixes.getOrDefault(prefix, 0) + 1);
            }
        }
        int maxLen = 0;
        for (int num : arr2) {
            String str = Integer.toString(num);
            for (int i = 1; i <= str.length(); ++i) {
                String prefix = str.substring(0, i);
                if (prefixes.containsKey(prefix)) {
                    maxLen = Math.max(maxLen, i);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}  