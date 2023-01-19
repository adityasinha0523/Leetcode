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

class problem2423{
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

    public static boolean equalFrequency(String word) {
        int[] count=new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0){
                count[i]--;
                if(checkEqual(count)){
                    return true;
                }
                count[i]++;
            }
        }
        return false;
    }

    public static boolean checkEqual(int[] count){
        int c=0;
        for (int i = 0; i < count.length; i++) {
            if(count[i]==0){
                continue;
            }else if(c==0){
                c=count[i];
            }else if(count[i]!=c){
                return false;
            }
        }
        return true;
    }
}  
