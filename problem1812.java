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

class problem1812{
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
        boolean sol= squareIsWhite("c7");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean squareIsWhite(String coordinates) {
        //boolean solution=true;
        Map<Character,Integer> hMap=new HashMap<>();
        hMap.put('a', 1);
        hMap.put('b', 2);
        hMap.put('c', 3);
        hMap.put('d', 4);
        hMap.put('e', 5);
        hMap.put('f', 6);
        hMap.put('g', 7);
        hMap.put('h', 8);
        char c1=coordinates.charAt(0);
        int first=hMap.get(c1);
        char c2=coordinates.charAt(1);
        int second=Character.getNumericValue(c2);
        int total=first+second;
        
        return total%2==0?false:true;
    }
}  