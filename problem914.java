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
import java.net.Inet4Address;

class problem914{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length<=1){
            return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0)+1);
        }
        boolean set=false;
        int sameValue=Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> hEntry : map.entrySet()) {
            int key=hEntry.getKey();
            int value=hEntry.getValue();
            if(set==false){
                set=true;
                sameValue=value;
                continue;
            }else{
                if(value<sameValue){
                    sameValue=value;
                }
            }
        }
        for (Map.Entry<Integer,Integer> hEntry : map.entrySet()) {
            //int key=hEntry.getKey();
            int value=hEntry.getValue();
            if(value%sameValue!=0){
                return false;
            }
        }
        return true;
    }
}  
