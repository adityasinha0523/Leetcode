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

class WC386P3{
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
        int[] nums=new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] nums2=new int[7];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
        }
        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=earliestSecondToMarkIndices(nums,nums2);
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
        System.out.println(sol);
        scan.close();
    }  

    public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        boolean[] marked = new boolean[n + 1]; // 1-indexed, to keep track of marked indices
        int markedCount = 0;
        
        // Initially mark all zeros
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && !marked[i + 1]) {
                marked[i + 1] = true;
                markedCount++;
            }
        }
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                k+=nums[i];
            }
        }
        int solution=k;
        for (int s = k; s < changeIndices.length; s++) {
            int index = changeIndices[s];
            // Decrement the value at nums[index - 1] if it's not already 0
            if(marked[index]==false){
                marked[index] = true;
                markedCount++;
            }
            solution++;
            // Check if all indices are marked
            if (markedCount == n) {
                return  solution; // +1 because we need to return the second, not the index
            }
        }
        
        // If not all indices are marked by the end
        return -1;
    }   
}  
