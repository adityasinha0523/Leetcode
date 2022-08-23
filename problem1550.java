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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem1550{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[9];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        boolean sol=threeConsecutiveOdds(num);
        System.out.println(sol);
        scan.close();
    }  

    public static boolean threeConsecutiveOdds(int[] arr) {
        int firstNumber=0;
        int secondeNumber=0;
        int thirdNumber=0;
        boolean solution=false;
        for (int i = 0; i < arr.length-2; i++) {
            firstNumber=arr[i];
            secondeNumber=arr[i+1];
            thirdNumber=arr[i+2];
            if(firstNumber%2!=0 &&secondeNumber%2!=0 && thirdNumber%2!=0){
                return true;
            }
        }
        return solution;
    }
}  