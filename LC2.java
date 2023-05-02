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

class LC2{
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

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] solution=new int[nums.length-k+1];
        int last=k-1;
        int start=0;
        int p=0;
        List<Integer> prevList=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(i==0){
                start=nums[i];
            }
            prevList.add(nums[i]);
            Collections.sort(prevList);
            int val=prevList.get(x-1);
            System.out.println("X Value is "+x);
            solution[p++]=val;
            
        }
        while(last<=nums.length-1){
            prevList.remove(start);
            Collections.sort(prevList);
            int val=prevList.get(x-1);
            System.out.println("X Value is "+x);
            solution[p++]=val;

        }
        return solution;
    }
}  