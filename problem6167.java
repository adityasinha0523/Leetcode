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

class problem6167{
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
        String s="abaccb";
        int[] distance=new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean sol=checkDistances(s,distance);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  


    public static boolean checkDistances(String s, int[] distance) {
        int[] diff=new int[26];
        int[] appeared=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(diff[c-'a']!=0){
                int valuePresent=diff[c-'a'];
                int totalDiff=Math.abs(i-valuePresent);
                diff[c-'a']=totalDiff;
            }else{
                diff[c-'a']=i+1;
            }
            appeared[c-'a']=1;
        }
        for (int i = 0; i < diff.length; i++) {
            if(diff[i]!=distance[i]){
                if(diff[i]!=0){
                    return false;
                }
                if(appeared[i]==1 && distance[i]!=0){
                    return false;
                }
            }
        }
        
        return true;
    }
}  