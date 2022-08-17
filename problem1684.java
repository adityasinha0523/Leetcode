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

class problem1684{
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
        String allowed=scan.nextLine();
        String[] words=new String[8];
        for (int i = 0; i < words.length; i++) {
            words[i]=scan.nextLine();
        }
        int sol=countConsistentStrings(allowed,words);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countConsistentStrings(String allowed, String[] words) {
        int solution=0;
        Map<Character,Integer> hMap=new HashMap<>();
        for (int i = 0; i < allowed.length(); i++) {
            hMap.put(allowed.charAt(i), hMap.getOrDefault(allowed.charAt(i), 0)+1);
        }
        for (int i = 0; i < words.length; i++) {
            String s=words[i];
            Map<Character,Integer> wordsMap=new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                wordsMap.put(s.charAt(j), wordsMap.getOrDefault(s.charAt(j), 0)+1);
            }
            boolean flag=false;
            for (Map.Entry<Character,Integer> hEntry : wordsMap.entrySet()) {
                Character c=hEntry.getKey();
                if(!hMap.containsKey(c)){
                    flag=true;
                }
            }
            if(flag==false){
                solution++;
            }
        }
        return solution;
    }
}  