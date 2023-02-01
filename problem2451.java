import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

class problem2451{
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
        String[] nums=new String[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        String sol=oddString(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  


    public static String oddString(String[] words) {
        Map<List<Integer>,Integer> map1=new HashMap<>();
        Map<List<Integer>,String> map2=new HashMap<>();
        String sol="";
        Set<List<Integer>> set=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String s=words[i];
            //int sum=0;
            List<Integer> list=new ArrayList<>();
            for (int j = 1; j < s.length(); j++) {
                int diff1=s.charAt(j)-'a';
                int diff2=s.charAt(j-1)-'a';
                int actualDiff=diff1-diff2;
                list.add(actualDiff);
                //sum+=actualDiff;
            }
            map1.put(list,map1.getOrDefault(list, 0)+1);
            map2.put(list, s);
        }
        for (Map.Entry<List<Integer>, Integer> hEntry : map1.entrySet()) {
            int key=hEntry.getValue();
            List<Integer> value=hEntry.getKey();
            if(key==1){
                return map2.get(value);
            }
        }
        return sol;
    }
}  