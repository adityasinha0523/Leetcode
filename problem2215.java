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

class problem2215{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> solution=new ArrayList<>();
        List<Integer> leftInteger=new ArrayList<>();
        List<Integer> rightInteger=new ArrayList<>();
        Set<Integer> leftSide=new HashSet<>();
        Set<Integer> rightSide=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            leftSide.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            rightSide.add(nums2[i]);
        }
        for (Integer integer : leftSide) {
            if(!rightSide.contains(integer)){
                leftInteger.add(integer);
            }
        }
        for (Integer integer : rightSide) {
            if(!leftSide.contains(integer)){
                rightInteger.add(integer);
            }
        }
        solution.add(leftInteger);
        solution.add(rightInteger);
        return solution;
    }
}  