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

class problem2161{
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

    public static int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThan=new ArrayList<>();
        List<Integer> equalThan=new ArrayList<>();
        List<Integer> greaterThan=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<pivot){
                lessThan.add(nums[i]);
            }else if(nums[i]==pivot){
                equalThan.add(nums[i]);
            }else{
                greaterThan.add(nums[i]);
            }
        }
        int k=0;
        int[] sol=new int[nums.length];
        for (int integer : lessThan) {
            sol[k++]=integer;
        }
        for (int i : equalThan) {
            sol[k++]=i;
        }
        for (int i : greaterThan) {
            sol[k++]=i;
        }
        return sol;
    }
}  