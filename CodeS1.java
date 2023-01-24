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

class CodeS1{
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
        int sol=findAnswer(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int findAnswer(int[] nums){
        int descendingVal=0;
        int ascendingVal=0;
        Stack<Integer> stack=new Stack<>();
        //Descending 
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()){
                stack.add(nums[i]);
            }else{
                int key=stack.peek();
                if(nums[i]+1==key){
                    stack.add(nums[i]);
                }
                else if(nums[i]>=key){
                    stack.pop();
                    descendingVal+=nums[i]-key+1;
                    key=nums[i]+1;
                    stack.add(key);
                    stack.add(nums[i]);
                }else{
                    stack.pop();
                    descendingVal+=key-nums[i]-1;
                    key=nums[i]-1;
                    stack.add(key);
                    stack.add(nums[i]);
                }
            }
        }
        //Ascending
        Stack<Integer> stack2=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack2.isEmpty()){
                stack2.add(nums[i]);
            }else{
                int key=stack.peek();
                if(nums[i]==key+1){
                    stack.add(nums[i]);
                }
                else if(nums[i]>=key){
                    stack.pop();
                    ascendingVal+=nums[i]-key+1;
                    key=nums[i]+1;
                    stack.add(key);
                    stack.add(nums[i]);
                }else{
                    stack.pop();
                    ascendingVal+=key-nums[i]-1;
                    key=nums[i]-1;
                    stack.add(key);
                    stack.add(nums[i]);
                }
            }
        }
        return Math.max(descendingVal, ascendingVal);
    }
}  