import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem2285{
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
        
        int[][] nums=new int[6][2];
        for (int i = 0; i < nums.length; i++) {
            for(int j=0;j<nums[0].length;j++){
                nums[i][j]=scan.nextInt();
            }
        }
        long sol=maximumImportance(5, nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static long maximumImportance2(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] r : roads) {
            ++degree[r[0]];
            ++degree[r[1]];
        }
        Arrays.sort(degree);
        long importance = 0;
        for (int i = 0; i < n; ++i) {
            importance += (i + 1L) * degree[i];
        }
        return importance;
    }

    public static long maximumImportance(int n, int[][] roads) {
        int[] degree=new int[n];
        for (int[] i : roads) {
            degree[i[0]]++;
            degree[i[1]]++;
        }
        Arrays.sort(degree);
        long importance=0L;
        for (int i = 0; i < n; i++) {
            importance+=(i+1L)*degree[i];
        }
        return importance;
    }
}  