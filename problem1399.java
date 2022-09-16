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

class problem1399{
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
        int sol=countLargestGroup(2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countLargestGroup(int n) {
        int solution=0;
        Map<Integer,Integer> hMap=new HashMap<>();
        while(n>0){
            int size=findSize(n);
            hMap.put(size, hMap.getOrDefault(size, 0)+1);
            n--;
        }
        int maxValue=Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> hEntry : hMap.entrySet()) {
            if(hEntry.getKey()>maxValue){
                maxValue=hEntry.getKey();
                solution=hEntry.getValue();
            }
        }
        return solution;
    }
    private static int findSize(int n){
        int size=0;
        while(n>0){
            n=n/10;
            size++;
        }
        return size;
    }
}  
