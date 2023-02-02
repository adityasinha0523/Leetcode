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

class problem2342{
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
        int sol=maximumSum(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int maximumSum(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            int sum=0;
            while(num!=0){
                int temp=num%10;
                num=num/10;
                sum+=temp;
            }
            if(map.containsKey(sum)){
                int value=map.get(sum);
                int second=nums[i];
                if(second>value){
                    map.put(sum,nums[i]);
                }
                max=Math.max(max, value+second);
            }else{
                map.put(sum, nums[i]);
            }
            //map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return max;
    }
}  