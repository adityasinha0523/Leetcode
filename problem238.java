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

class problem238{
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
        
        int[] nums=new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=productExceptSelf2(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] productExceptSelf2(int[] nums) {
        int[] leftProduct=new int[nums.length];
        int[] rightProduct=new int[nums.length];
        leftProduct[0]=1;
        rightProduct[rightProduct.length-1]=1;
        int k=1;
        for (int i = 0; i < nums.length-1; i++) {
            leftProduct[k]=nums[i]*leftProduct[k-1];
            k++;
        }
        k=nums.length-2;
        for (int i = nums.length-1; i >0; i--) {
            rightProduct[k]=nums[i]*rightProduct[k+1];
            k--;
        }
        int[] sol=new int[nums.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i]=leftProduct[i]*rightProduct[i];
        }
        return sol;
    }



    public static int[] productExceptSelf(int[] nums) {
        int[] forwardProduct=new int[nums.length];
        int[] backwardProduct=new int[nums.length];
        forwardProduct[0]=nums[0];
        backwardProduct[nums.length-1]=nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            forwardProduct[i]=forwardProduct[i-1]*nums[i];
        }
        for (int i = nums.length-2; i >=0; i--) {
            backwardProduct[i]=backwardProduct[i+1]*nums[i];
        }
        int[] sol=new int[nums.length];
        for (int i = 0; i < sol.length; i++) {
            if(i==0){
                sol[i]=backwardProduct[1];
            }else if(i==sol.length-1){
                sol[i]=forwardProduct[forwardProduct.length-2];
            }
            else{
                sol[i]=forwardProduct[i-1]*backwardProduct[i+1];
            }
        }
        return sol;
    }
}  