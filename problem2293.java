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

class problem2293{
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

        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=minMaxGame(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int minMaxGame(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for (Integer integer : nums) {
            list.add(integer);
        }
        while(list.size()!=1){
            List<Integer> list1=new ArrayList<>();
            int k=0;
            int even=0;
            for (int i = 0; i < list.size()-1; i=i+2) {
                int first=list.get(i);
                int second=list.get(i+1);
                if(even%2==0){
                    list1.add(Math.min(first,second));
                    even++;
                }else{
                    list1.add(Math.max(first, second));
                    even++;
                }
            }
            list.clear();
            for (Integer integer : list1) {
                list.add(integer);
            }
        }
        return list.get(0);
    }
}  
