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

class problem1213{
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
        int[] arr1=new int[]{1,2,3,4,5};
        int[] arr2=new int[]{8,2,5,7,9};
        int[] arr3=new int[]{1,3,4,10,8};
        List<Integer> sol=arraysIntersection(arr1, arr2, arr3);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> set1=new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        Set<Integer> set2=new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if(set1.contains(arr2[i])){
                set2.add(arr2[i]);
            }
        }
        Set<Integer> set3=new HashSet<>();
        for (int i = 0; i < arr3.length; i++) {
            if(set2.contains(arr3[i])){
                set3.add(arr3[i]);
            }
        }
        List<Integer> solution=new ArrayList<>();
        for (Integer integer : set3) {
            solution.add(integer);
        }
        Collections.sort(solution);
        return solution;
    }
}  
