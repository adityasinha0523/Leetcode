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

class problem1498{
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
        
        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int target=10;
        int sol=numSubseq(nums, target);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod=(int)1e9+7;
        int i=0;
        int j=nums.length-1;
        int count=0;
        int[] power=new int[nums.length];
        power[0]=1;
        for (int k = 1; k < power.length; k++) {
            power[k]=(power[k-1]*2)%mod;
        }
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count=(count+power[j-i])%mod;
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }
        }
        return count;
    }
}  