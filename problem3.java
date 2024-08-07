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
import java.util.function.LongFunction;
import java.lang.*;

class problem3{
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
        int sol=lengthOfLongestSubstring("abcabcbb");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int left=0;
        int right=0;
        Set<Character> set=new HashSet<>();
        int ans=0;
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                while(set.contains(s.charAt(left))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }else{
                set.add(s.charAt(right));
                ans=Math.max(ans, set.size());
            }
        }
        return ans;
    }
}  
