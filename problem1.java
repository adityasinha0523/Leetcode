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

class problem1{
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
        int[] nums=new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int target=scan.nextInt();
        int[] sol=twoSum(nums, target);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val=nums[i];
            if(map.containsKey(target-val)){
                int[] ans=new int[2];
                ans[0]=map.get(target-val);
                ans[1]=i;
                return ans;
            }else{
                map.put(nums[i], i);
            }
        }
        int[] sol=new int[]{-1,-1};
        
        return sol;
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> hMap=new HashMap<>();
        int[] sol=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hMap.containsKey(target-nums[i])){
                sol[0]=hMap.get(target-nums[i]);
                sol[1]=i;
                return sol;
            }else{
                hMap.put(nums[i], i);
            }
        }
        return sol;
    }



    public static int[] twoSum(int[] nums, int target) {
        int[] solution=new int[2];
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hMap.containsKey(target-nums[i])){
                solution[0]=i;
                solution[1]=hMap.get(target-nums[i]);
                break;
            }else{
                hMap.put(nums[i], i);
            }
        }
        return solution;
    }
}  