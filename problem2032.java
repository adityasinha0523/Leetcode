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
import java.net.Inet4Address;

class problem2032{
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
        List<Integer> sol=twoOutOfThree(null, null, null);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> set3=new HashSet<>();
        Set<Integer> sol=new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (int i = 0; i < nums3.length; i++) {
            set3.add(nums3[i]);
        }
        for (Integer integer : set1) {
            if(set2.contains(integer)){
                sol.add(integer);
            }
            if(set3.contains(integer)){
                sol.add(integer);
            }
        }
        for (Integer integer : set2) {
            if(set1.contains(integer)){
                sol.add(integer);
            }
            if(set3.contains(integer)){
                sol.add(integer);
            }
        }
        for (Integer integer : set3) {
            if(set1.contains(integer)){
                sol.add(integer);
            }
            if(set2.contains(integer)){
                sol.add(integer);
            }
        }
        List<Integer> solution=new ArrayList<>(sol);
        return solution;
    }
}  
