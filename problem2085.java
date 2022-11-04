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

class problem2085{
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
        String[] words1={"a","ab"};
        String[] words2={"a","a","a","ab"};
        int sol=countWords(words1, words2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countWords(String[] words1, String[] words2) {
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        int solution=0;
        for (int i = 0; i < words1.length; i++) {
            set1.add(words1[i]);
        }
        for (int i = 0; i < words2.length; i++) {
            set2.add(words2[i]);
        }
        for (int i = 0; i < words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0)+1);
        }
        for (int i = 0; i < words2.length; i++) {
            map2.put(words2[i], map2.getOrDefault(words2[i], 0)+1);
        }
        for (Map.Entry<String,Integer> hEntry : map1.entrySet()) {
            String key=hEntry.getKey();
            int value=hEntry.getValue();
            if(value==1){
                if(set2.contains(key)&& map2.get(key)==1){
                    solution++;
                }
            }
            
        }
        return solution;
    }
}  