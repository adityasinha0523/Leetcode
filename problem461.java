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

class problem461{
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

        int x=scan.nextInt();
        int y=scan.nextInt();
        int sol=hammingDistance(x,y);
        System.out.println(sol);
        scan.close();
    }  

    public static int hammingDistance(int x, int y) {
        int solution=0;
        String xValue=Integer.toBinaryString(x);
        String yValue=Integer.toBinaryString(y);
        int range=xValue.length()>yValue.length()?yValue.length():xValue.length();
        int xIndex=xValue.length()-1;
        int yIndex=yValue.length()-1;
        for (int i = 0; i < range; i++) {
            if(xValue.charAt(xIndex--)!=yValue.charAt(yIndex--)){
                solution++;
            }
        }
        if(xIndex!=-1){
            while(xIndex!=-1){
                if(xValue.charAt(xIndex)=='1'){
                    solution++;
                }
                xIndex--;
            }
        }
        if(yIndex!=-1){
            while(yIndex!=-1){
                if(yValue.charAt(yIndex)=='1'){
                    solution++;
                }
                yIndex--;
            }
        }
        return solution;
    }
}  