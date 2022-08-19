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

class problem2278{
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

        
        String s=scan.nextLine();
        char letter=scan.next().charAt(0);
        int sol=percentageLetter(s,letter);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int percentageLetter(String s, char letter) {
        int solution=0;
        int size=s.length();
        int count=0;
        Map<Character,Integer> hMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            hMap.put(c,hMap.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character,Integer> hEntry : hMap.entrySet()) {
            if(hEntry.getKey().equals(letter)){
                count=hEntry.getValue();
            }
        }
        solution=(int) Math.floor(count*100/size);
        return solution;
    }
}  