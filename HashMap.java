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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMap{
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
        String[] string1=new String[2];
        for (int i = 0; i < string1.length; i++) {
            string1[i]=scan.nextLine();
        }
        String[] string2=new String[2];
        for (int i = 0; i < string2.length; i++) {
            string2[i]=scan.nextLine();
        }
        boolean answer=arrayStringsAreEqual(string1,string2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(answer);
        scan.close();
    }  

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        HashMap<Character,Integer> hMap1=new HashMap<>();
        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < word1[i].length(); j++) {
                char c=word1[i].charAt(j);
                hMap1.put(c, hMap1.getOrDefault(c, 0)+1);
            }
            
        }
        HashMap<Character,Integer> hMap2=new HashMap<>();
        for (int i = 0; i < word2.length; i++) {
            for (int j = 0; j < word2[i].length(); j++) {
                char c=word2[i].charAt(j);
                hMap2.put(c, hMap2.getOrDefault(c, 0)+1);
            }    
        }
        
        for (Map.Entry<Character,Integer> hEntry: hMap2.entrySet()) {
            char value=hEntry.getKey();
            int count=hEntry.getValue();
            if(hMap1.containsKey(value) ){
                int count2=hMap1.get(value);
                if(count!=count2){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}  