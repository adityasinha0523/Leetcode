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

class problem2155{
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

    public static List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> solution=new ArrayList<>();
        int zero=0;
        int one=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                one++;
            }
        }
        int maxSum=one;
        solution.add(0);
        int leftIndex=0;
        while(leftIndex<nums.length){
            if(nums[leftIndex]==0){
                zero++;
            }else{
                one=one-1;
            }
            if(zero+one>maxSum){
                maxSum=zero+one;
                solution.clear();
                solution.add(leftIndex+1);
            }else if(zero+one==maxSum){
                solution.add(leftIndex+1);
            }
            leftIndex++;
        }
        return solution;
    }
}  