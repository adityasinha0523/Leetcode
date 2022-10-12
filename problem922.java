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

class problem922{
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
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=sortArrayByParityII(nums);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] sortArrayByParityII(int[] nums) {
        List<Integer> oddList=new ArrayList<>();
        List<Integer> evenList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                evenList.add(nums[i]);
            }else{
                oddList.add(nums[i]);
            }
        }
        int[] solution=new int[nums.length];
        int oddIndex=0;
        int evenIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2!=0){
                solution[i]=oddList.get(oddIndex++);
            }else{
                solution[i]=evenList.get(evenIndex++);
            }
            
        }
        return solution;
    }
}  