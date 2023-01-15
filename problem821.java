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

class problem821{
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
        String s="aaab";
        Character c='b';
        int[] sol=shortestToChar(s,c);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] shortestToChar(String s, char c) {
        List<Integer> list=new ArrayList<>();
        int[] sol=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                list.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int minDistance=Integer.MAX_VALUE;
            if(s.charAt(i)==c){
                sol[i]=0;
                continue;
            }else{
                for (int j : list) {
                    minDistance=Math.min(minDistance, (int)Math.abs(i-j));
                }
                sol[i]=minDistance;
            }
        }
        return sol;
    }


    public static int[] shortestToChar2(String s, char c) {
        List<Integer> list=new ArrayList<>();
        int[] sol=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                list.add(i);
            }
        }
        int k=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                sol[k++]=0;
            }else{
                int minDis=Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    int value=list.get(j);
                    minDis=Math.min(minDis, Math.abs(i-value));
                }
                sol[k++]=minDis;
            }
        }
        return sol;
    }
}  