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

class problem1002{
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
        String[] string=new String[2];
        for (int i = 0; i < string.length; i++) {
            string[i]=scan.nextLine();
        }
        List<String> sol=commonChars(string);
        for(int i=0;i<sol.size();i++){
            System.out.println(sol.get(i));
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<String> commonChars(String[] words) {
        int[] finalCount=new int[26];
        String firstString=words[0];
        List<String> solution=new ArrayList<>();
        for (int i = 0; i < firstString.length(); i++) {
            finalCount[firstString.charAt(i)-'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            String string=words[i];
            int[] count=new int[26];
            for (int j = 0; j < string.length(); j++) {
                count[string.charAt(j)-'a']++;
            }
            for (int j = 0; j < finalCount.length; j++) {
                if(finalCount[j]!=count[j]){
                    finalCount[j]=Math.min(finalCount[j], count[j]);
                }
            }
        }
        for (int i = 0; i < finalCount.length; i++) {
            if(finalCount[i]!=0){
                while(finalCount[i]!=0){
                    char c=(char)(i+97);
                    solution.add(Character.toString(c));
                    finalCount[i]--;
                }
            }
        }
        return solution;
    }
}  
