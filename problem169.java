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
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;

class problem169{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[3];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int sol=majorityElement(num);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int majorityElement2(int[] nums) {
        int majorityElement=nums[0];
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=majorityElement){
                count--;
                if(count==0){
                    majorityElement=nums[i];
                    count=1;
                }
            }else{
                count++;
            }
        }
        int val=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==majorityElement){
                val++;
            }
        }
        return (val>=(nums.length/2))?val:-1;
    }

    public static int majorityElement(int[] nums) {
        int solution=0;
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0)+1);
        }
        for (Map.Entry<Integer,Integer> hEntry : hMap.entrySet()) {
            int value=hEntry.getValue();
            if(value>nums.length/2){
                return hEntry.getKey();
            }
        }
        return solution;
    }
}  