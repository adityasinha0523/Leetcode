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

class problem1018{
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
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        List<Boolean> sol=prefixesDivBy5(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Boolean integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        //Boolean[] sol=new Boolean[nums.length];
        List<Boolean> sol=new ArrayList<>();
        int lastIndex=nums.length-1;
        for (int i = nums.length-1; i >=0; i--) {
            int starting=i;
            int k=0;
            int sum=0;
            for (int j = starting; j >=0; j--) {
                sum+=(int)Math.pow(2, k++)*nums[j];
            }
            if(sum%5==0){
                sol.add(true);
                //sol[lastIndex--]=false;
            }else{
                sol.add(false);
                //sol[lastIndex--]=true;
            }
        }
        Collections.reverse(sol);
        return sol;
    }
}  