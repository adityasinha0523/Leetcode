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
import java.text.CollationElementIterator;
import java.time.chrono.HijrahEra;

class problem2148{
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
        String[] names=new String[3];
        for (int i = 0; i < names.length; i++) {
            names[i]=scan.nextLine();
        }
        int[] heights=new int[3];
        for (int i = 0; i < heights.length; i++) {
            heights[i]=scan.nextInt();
        }
        String[] sol=sortPeople(names,heights);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            hMap.put(heights[i],i);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            list.add(heights[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        int k=0;
        String[] solution=new String[names.length];
        for (int i = 0; i < list.size(); i++) {
            int t=list.get(i);
            int value=hMap.get(t);
            solution[k++]=names[value];
        }
        return solution;
    }

}  
