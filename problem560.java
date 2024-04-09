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

class problem560{
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

    public static int subarraySum2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        map.put(sum, 1);
        int currentSum=0;
        int solution=0;
        for (int i = 0; i < nums.length; i++) {
            currentSum+=nums[i];
            int val=currentSum-k;
            if(map.containsKey(val)){
                solution+=map.get(val);
            }
                map.put(currentSum,map.getOrDefault(currentSum, 0)+1);
            
        }
        return solution;
    }

    public static int subarraySum(int[] A, int K) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if(map.containsKey(sum-K)){
                count+=map.get(sum-K);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}  