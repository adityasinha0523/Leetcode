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

class problem2485{
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
        int sol=pivotInteger2(8);
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int pivotInteger(int n) {
        int[] forwardSum=new int[n+1];
        int[] backwardSum=new int[n+1];
        for (int i = 1; i <=n; i++) {
            forwardSum[i]=forwardSum[i-1]+i;
        }
        backwardSum[n]=n;
        for (int i = n-1; i >= 0; i--) {
            backwardSum[i]=backwardSum[i+1]+i;
        }
        for (int i = 0; i < backwardSum.length; i++) {
            if(forwardSum[i]==backwardSum[i]){
                return i;
            }
        }
        return -1;
    }

    public static int pivotInteger2(int n) {
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
        }

        for (int i = 1; i < n; i++) {
            left[i] += left[i - 1];
        }

        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            right[i] = i + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] += right[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}  
