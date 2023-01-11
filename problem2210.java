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
import java.util.*;
import java.lang.*;

class problem2210{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    boolean valley=false;
    boolean hill=false;
    public int countHillValley(int[] nums) {
        int solution=0;
        for (int i = 1; i < nums.length-1; i++) {
            if(i==1 && nums[i]==nums[i-1]){
                continue;
            }else{
            int backward=i-1;
            int valueBack=0;
            while(backward!=-1){
                if(nums[i]!=nums[backward]){
                    valueBack=nums[backward];
                    break;
                }
                backward--;
            }
            int forward=i+1;
            int valueForward=0;
            while(forward!=nums.length){
                if(nums[i]!=nums[forward]){
                    valueForward=nums[forward];
                    break;
                }
                forward++;
            }
            if(nums[i]>valueBack && nums[i]>valueForward && hill==false && valueForward!=0 && valueBack!=0){
                solution++;
                hill=true;
                valley=false;
            }
            if(nums[i]<valueBack && nums[i]<valueForward && valley==false && valueForward!=0 && valueBack!=0){
                solution++;
                valley=true;
                hill=false;
            }
        }
        } 
        return solution;
    }
}  