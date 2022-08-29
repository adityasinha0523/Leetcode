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

class problem1652{
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
        int[] num=new int[4];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int k=scan.nextInt();
        int[] sol=decrypt(num, k);
        
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        scan.close();
    }  

    public static int[] decrypt(int[] code, int k) {
        if(k==0){
            int[] solution=new int[code.length];
            return solution;
        }
        else if(k>0){
            int[] solution=new int[code.length];
            for (int i = 0; i < code.length; i++) {
                int temp=k;
                int nextIndex=i+1;
                int sum=0;
                while(temp>0){
                    sum+=code[nextIndex%code.length];
                    nextIndex++;
                    temp--;
                }
                solution[i]=sum;
            }
            return solution;
        }else{
            int[] solution=new int[code.length];
            for (int i = 0; i < code.length; i++) {
                int temp=k*-1;
                int nextIndex=i+code.length-1;
                int sum=0;
                while(temp>0){
                    sum+=code[nextIndex%code.length];
                    nextIndex--;
                    temp--;
                }
                solution[i]=sum;
            }
            return solution;
        }
    }
}  