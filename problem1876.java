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

class problem1876{
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
        String s="xyzzaz";
        int sol=countGoodSubstrings(s);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        int solution=0;
        char prev;
        Map<Character,Integer> map=new HashMap<>();
        char c1=s.charAt(0);
        char c2=s.charAt(1);
        char c3=s.charAt(2);
        int k=0;
        map.put(c1,map.getOrDefault(c1, 0)+1);
        map.put(c2,map.getOrDefault(c2, 0)+1);
        map.put(c3,map.getOrDefault(c3, 0)+1);
        for (int i = 3; i < s.length(); i++) {
            if(map.size()==3){
                solution++;
            }
            int value=map.get(s.charAt(k));
            if(value==1){
                map.remove(s.charAt(k));
            }else{
                map.put(s.charAt(k),map.get(s.charAt(k))-1);
            }
            k++;
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        if(map.size()==3){
            solution++;
        }
        return solution;
    }
}  