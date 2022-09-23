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

class problem2341{
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
        //scan.nextLine();
        //To take int array as input
        
        int[] nums=new int[1];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=numberOfPairs(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol[0]);
        System.out.println(sol[1]);
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] numberOfPairs(int[] nums) {
        int[] sol=new int[2];
        sol[0]=0;
        sol[1]=0;
        int pair=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                pair++;
                list.remove(Integer.valueOf(nums[i]));
            }else{
                list.add(nums[i]);
            }
        }
        sol[0]=pair;
        sol[1]=list.size();
        return sol;
    }
}  