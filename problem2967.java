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

class problem2967{
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
        //System.out.println(sol);
        scan.close();
    }  

    public static long minimumCost(int[] nums) {
        Arrays.sort(nums);
        long ans=0;
        int med=nums[nums.length/2];
        int val1=leftVal(med);
        int val2=rightVal(med);
        long minSum1=minSum(val1,nums);
        long minSum2=minSum(val2,nums);
        ans=(long)Math.min(minSum1, minSum2);
        return ans;
    }

    public static boolean palindrome(int num){
        int dup=num;
        int rev=0;
        while(dup!=0){
            rev=rev*10+dup%10;
            dup=dup/10;
        }
        return rev==num;
    }

    public static int rightVal(int num){
        if(!palindrome(num)){
            num++;
        }
        return num;
    }

    public static int leftVal(int num){
        if(!palindrome(num)){
            num--;
        }
        return num;
    }

    public static long minSum(int val,int[] arr){
        long sol=0l;
        for (int i = 0; i < arr.length; i++) {
            sol+=Math.abs(arr[i]-val);
        }
        return sol;
    }
}  