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

class problem884{
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
        String s1="apple apple";
        String s2="babab";
        String[] sol=uncommonFromSentences(s1, s2);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> solution=new ArrayList<>();
        Map<String,Integer> hMap1=new HashMap<>();
        String[] s1Arr=s1.split(" ");
        Set<String> set1=new HashSet<>();
        for (String string : s1Arr) {
            hMap1.put(string,hMap1.getOrDefault(string, 0)+1);
            set1.add(string);
        }
        Map<String,Integer> hMap2=new HashMap<>();
        Set<String> set2=new HashSet<>();
        String[] s2Arr=s2.split(" ");
        for (String string : s2Arr) {
            hMap2.put(string,hMap2.getOrDefault(string, 0)+1);
            set2.add(string);
        }
        for (Map.Entry<String,Integer> hEntry : hMap1.entrySet()) {
            if(hEntry.getValue()==1 && !set2.contains(hEntry.getKey())){
                solution.add(hEntry.getKey());
            }
        }
        for (Map.Entry<String,Integer> hEntry : hMap2.entrySet()) {
            if(hEntry.getValue()==1 && !set1.contains(hEntry.getKey())){
                solution.add(hEntry.getKey());
            }
        }
        String[] sol=solution.toArray(new String[0]);
        
        return sol;
    }
}  