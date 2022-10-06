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

class problem1056{
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
        boolean sol=confusingNumber(916);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean confusingNumber(int n) {
        boolean solution=true;
        Set<Integer> set=new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(6);
        set.add(8);
        set.add(9);
        int newValue=0;
        int k=1;
        int store=n;
        while(n!=0){
            int temp=n%10;
            if(!set.contains(temp)){
                return false;
            }else{
                if(temp==6){
                    temp=9;
                }else if(temp==9){
                    temp=6;
                }
                newValue=newValue*10+temp;
            }
            k=k*10;
            n=n/10;
        }
        if(newValue==store){
            return false;
        }
        return solution;
    }
}  
