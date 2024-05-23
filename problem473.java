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

import javax.print.DocFlavor.READER;

import java.lang.*;

class problem473{
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

        //String xValue=Integer.toBinaryString(5);
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
    
    public static boolean makesquare(int[] matchsticks) {
        int sum=0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum+=matchsticks[i];
        }
        int[] arr=new int[4];
        if(sum%4==0){
            return false;
        }
        return backtrack(matchsticks,arr,sum/4,0);
    }

    boolean backtrack(int[] matchsticks,int[] arr,int target,int index){
        if(index==matchsticks.length){
            if(arr[0]==target &&arr[1]==target&&arr[1]==target&&arr[1]==target){
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if(arr[i]+matchsticks[index]>target){
                continue;
            }
            arr[i]+=matchsticks[i];
            if(backtrack(matchsticks, arr, target, index+1)){
                return true;
            }
            arr[i]-=matchsticks[i];
        }
        return false;
    }

}  