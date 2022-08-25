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

class problem349{
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
        int[] nums1=new int[4];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=scan.nextInt();
        }
        int[] nums2=new int[2];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
        }
        int[] sol=intersection(nums1,nums2);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] sol1=new int[1001];
        int[] sol2=new int[1001];
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            sol1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            sol2[nums2[i]]++;
        }
        for (int i = 0; i < sol2.length; i++) {
            if(sol1[i]>0 &&sol2[i]>0){
                list.add(i);
            }
        }
        int[] solution=new int[list.size()];
        int k=0;
        for (Integer integer : list) {
            solution[k++]=integer;
        }
        return solution;
    }
}  
