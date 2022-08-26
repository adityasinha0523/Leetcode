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

class problem1880{
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

        String firstWord=scan.nextLine();
        String secondWord=scan.nextLine();
        String targetWord=scan.nextLine();
        boolean sol=isSumEqual(firstWord,secondWord,targetWord);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sumFirstWord=0;
        int multiple=1;
        for (int i = firstWord.length()-1; i >=0; i--) {
            char c=firstWord.charAt(i);
            int number=c-97;
            sumFirstWord=sumFirstWord+number*multiple;
            multiple=multiple*10;
        }
        int sumSecondWord=0;
        multiple=1;
        for (int i = secondWord.length()-1; i >=0; i--) {
            char c=secondWord.charAt(i);
            int number=c-97;
            sumSecondWord=sumSecondWord+number*multiple;
            multiple=multiple*10;
        }
        int sumThirdWord=0;
        multiple=1;
        for (int i = targetWord.length()-1; i >=0; i--) {
            char c=targetWord.charAt(i);
            int number=c-97;
            sumThirdWord=sumThirdWord+number*multiple;
            multiple=multiple*10;
        }
        
        return (sumFirstWord+sumSecondWord==sumThirdWord)?true:false;
    }
}  