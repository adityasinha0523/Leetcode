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

class problem1534{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=countGoodTriplets(nums, 7, 2, 3);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int solution=0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int j2 = j+1; j2 < arr.length; j2++) {
                    int a1=Math.abs(arr[i]-arr[j]);
                    int b1=Math.abs(arr[j]-arr[j2]);
                    int c1=Math.abs(arr[i]-arr[j2]);
                    if(a1<=a && b1<=b && c1<=c){
                        //System.out.println("Value of a1"+a1);
                        //System.out.println("Value of b1"+b1);
                        //System.out.println("Value of c1"+c1);
                        solution++;
                    }
                }
            }
        }
        return solution;
    }
}  
