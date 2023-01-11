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

class problem2078{
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
        
        int[] nums=new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol= maxDistance(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int maxDistance2(int[] colors) {
        int right=colors.length-1;
        int n=colors.length-1;
        int left=0;
        while(colors[left]==colors[right]){
            left++;
        }
        while(colors[right]==colors[0]){
            right--;
        }
        return Math.max(right, n-left);
    }

    public static int maxDistance(int[] colors) {
        int last=colors.length-1;
        int first=0;
        int solution=0;
        while(first<last){
            if(colors[last]!=colors[first]){
                solution=Math.max(solution,Math.abs(last-first));
            }
            last--;
        }
        first=0;
        last=colors.length-1;
        while(first<last){
            if(colors[last]!=colors[first]){
                solution=Math.max(solution,Math.abs(last-first));
            }
            first++;
        }
        return solution;
    }
}  