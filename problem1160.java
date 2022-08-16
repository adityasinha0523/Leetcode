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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem1160{
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
        String[] num=new String[3];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextLine();
        }
        String character=scan.nextLine();
        int sol=countCharacters(num, character);

        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countCharacters(String[] words, String chars) {
        int solution=0;
        Map<Character,Integer> hMap=new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            hMap.put(chars.charAt(i), hMap.getOrDefault(chars.charAt(i), 0)+1);
        }
        for (int i = 0; i < words.length; i++) {
            Map<Character,Integer> newMap=new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                newMap.put(words[i].charAt(j), newMap.getOrDefault(words[i].charAt(j), 0)+1);
            }
            int smallSolution=0;
            for (Map.Entry<Character,Integer> hEntry : newMap.entrySet()) {
                Character key=hEntry.getKey();
                int value=hEntry.getValue();
                if(hMap.containsKey(key)){
                    if(hMap.get(key)>=value){
                        smallSolution++;
                    }
                }
            }
            if(smallSolution==newMap.size()){
                solution+=words[i].length();
            }    
        }
        return solution;
    }
}  