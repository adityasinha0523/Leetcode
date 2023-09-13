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

class problem414{
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
        int[] num=new int[6];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int sol=thirdMax(num);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> sortNum=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(sortNum.contains(nums[i])){
                continue;
            }
            if(sortNum.size()==3){
                if(sortNum.first()<nums[i]){
                    sortNum.pollFirst();
                    sortNum.add(nums[i]);
                }
            }
            else{
                sortNum.add(nums[i]);
            }
        }
        if(sortNum.size()==3){
            return sortNum.first();
        }
        return sortNum.last();
    }
}  