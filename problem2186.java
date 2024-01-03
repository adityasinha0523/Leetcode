import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem2186{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();


        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int minSteps(String s, String t) {
        int[] count1=new int[26];
        int[] count2=new int[26];
        int solution=0;
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < count2.length; i++) {
            if(count2[i]>0 && count1[i]==0){
                solution+=count2[i];
                continue;
            }else if(count2[i]-count1[i]>0){
                solution+=count2[i]-count1[i];
            }
        }
        for (int i = 0; i < count1.length; i++) {
            if(count1[i]>0 && count2[i]==0){
                solution+=count1[i];
            }
            else if(count1[i]-count2[i]>0){
                solution+=count1[i]-count2[i];
            }
        }
        return solution;
    }
}  