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

class problem80{
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

    public static int removeDuplicates(int[] nums) {
        /*int counter=1;
        int solution=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]&&counter<3){
                solution++;
                counter++;
            }else if(nums[i]!=nums[i-1]){
                counter=1;
                solution++;
            }
        }
        return solution;*/

        int counter=0;
        int index=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                counter++;

            }else{
                counter=0;
            }
            if(counter<=1){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}  