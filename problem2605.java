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

class problem2605{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  


    public static int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minValue1=Integer.MAX_VALUE;
        int minValue2=Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
            if(nums1[i]<minValue1){
                minValue1=nums1[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                return nums2[i];
            }else{
                if(nums2[i]<minValue2){
                    minValue2=nums2[i];
                }
            }
        }
        int sum=0;
        if(minValue1<minValue2){
            sum=minValue1*10+minValue2;
        }else{
            sum=minValue2*10+minValue1;
        }
        return sum;
    }
}  