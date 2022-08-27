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

class problem1331{
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
        int[] num=new int[9];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        
        int[] sol=arrayRankTransform(num);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] arrayRankTransform(int[] arr) {
        int[] sol=new int[arr.length];
        Map<Integer,Integer> hMap=new HashMap<>();
        int[] temp=new int[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        
        for (int i = 0; i < temp.length; i++) {
            hMap.putIfAbsent(temp[i], hMap.size()+1);
        }
        for (int i = 0; i < arr.length; i++) {
            sol[i]=hMap.get(arr[i]);
        }
        return sol;
    }
}  