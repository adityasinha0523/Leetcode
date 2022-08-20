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

class problem2379{
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

        
        String blocks=scan.nextLine();
        int k=scan.nextInt();
        int sol=minimumRecolors(blocks,k);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    /*public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), ans = n, i=0, j=0, wc=0;
        while(j < k){
            if(blocks.charAt(j++) == 'W') wc++;
        }
        while(j < n){
            ans = Math.min(ans, wc);
            if(blocks.charAt(i++)=='W') wc--;
            if(blocks.charAt(j++)=='W') wc++;
        }
        return ans = Math.min(ans, wc);
    }*/
    public static int minimumRecolors(String blocks, int k) {
        int wCount=0;
        int n=blocks.length();
        int j=0;
        int i=0;
        int ans=Integer.MAX_VALUE;
        while(j<k){
            if(blocks.charAt(j++)=='W'){
                wCount++;
            }
        }
        while(j<n){
            ans=Math.min(ans, wCount);
            if(blocks.charAt(i++)=='W'){
                wCount--;
            }
            if(blocks.charAt(j++)=='W'){
                wCount++;
            }
        }
        return Math.min(wCount, ans);
    }
}  