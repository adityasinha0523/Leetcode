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

class problem1243{
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
        List<Integer> sol=transformArray(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> transformArray(int[] arr) {
        while(true){
            boolean change=false;
            int[] temp=new int[arr.length];
            temp[0]=arr[0];
            temp[arr.length-1]=arr[arr.length-1];
            for (int i = 1; i < arr.length -1; i++) {
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    temp[i]=arr[i]-1;
                    change=true;
                }
                else if(arr[i]<arr[i-1] && arr[i]<arr[i+1]){
                    temp[i]=arr[i]+1;
                    change=true;
                }else{
                    temp[i]=arr[i];
                }
            }
            arr=temp;
            if(change==false){
                break;
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}  
