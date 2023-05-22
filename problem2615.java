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

class problem2615{
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

    public static long[] distance(int[] nums) {
        long[] sol=new long[nums.length];
        int k=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value=nums[i];
            if(map.containsKey(value)){
                List<Integer> curr=map.get(value);
                curr.add(i);
                map.put(value,curr);
            }else{
                List<Integer> curr=new ArrayList<>();
                curr.add(i);
                map.put(value, curr);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int val=nums[i];
            List<Integer> curr=map.get(val);
            if(curr.size()>1){
                int totalSum=0;
                    for (int j = 0; j < curr.size(); j++) {
                        if(curr.get(j)!=i){
                            int sum=Math.abs(i-curr.get(j));
                            totalSum+=sum;
                        }
                    }
                    sol[k++]=totalSum;
            }
            else{
                sol[k++]=0;
            }
        }
        return sol;
    }
}  