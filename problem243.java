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

class problem243{
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
        String[] wordsDict=new String[5];
        for (int i = 0; i < wordsDict.length; i++) {
            wordsDict[i]=scan.nextLine();
        }
        String word1=scan.nextLine();
        String word2=scan.nextLine();
        int sol=shortestDistance(wordsDict,word1,word2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int solution=Integer.MAX_VALUE;
        int i1=-1;
        int i2=-1;
        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)){
                i1=i;
                if(i2!=-1){
                    solution=Math.min(solution, Math.abs(i2-i1));
                    
                }
            }
            if(wordsDict[i].equals(word2)){
                i2=i;
                if(i1!=-1){
                    solution=Math.min(solution, Math.abs(i1-i2));
                }
            }
        }

        return solution;
    }
}  