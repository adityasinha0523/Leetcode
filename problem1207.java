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

class problem1207{
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
        int[] num=new int[6];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        boolean sol=uniqueOccurrences(num);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean uniqueOccurrences(int[] arr) {
        boolean solution=true;
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0)+1);
        }
        Set<Integer> set= new HashSet<>();
        for (Map.Entry<Integer,Integer> hEntry : hMap.entrySet()) {
            if(set.contains(hEntry.getValue())){
                return false;
            }
            set.add(hEntry.getValue());
        }
        return solution;
    }
}  