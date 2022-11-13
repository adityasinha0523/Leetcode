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

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import java.lang.*;
import java.net.Inet4Address;

class problem1742{
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
        //System.out.println(sol);
        scan.close();
    }  

    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map=new HashMap<>();
        int sol=0;
        for (int i = lowLimit; i <=highLimit; i++) {
            int d=findSum(i);
            map.put(d, map.getOrDefault(d, 0)+1);
            sol=Math.max(sol, map.get(d));
        }
        return sol;
    }

    public static int findSum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}  