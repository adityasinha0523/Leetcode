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

class problem49{
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
        int[] num=new int[4];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        String[] str=new String[3];
        str[0]="afdw";
        str[1]="aweer";
        str[2]="car";
        List<List<String>> sol=groupAnagrams2(str);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    } 
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> solution=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str=strs[i];
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String s1=new String(c);
            if(!solution.containsKey(s1)){
                List<String> s2=new ArrayList<>();
                s2.add(strs[i]);
                solution.put(s1, s2);
            }else{
                List<String> s3=solution.get(s1);
                s3.add(strs[i]);
                solution.put(s1, s3);
            }
        }
        return new ArrayList<>(solution.values());
    }



    
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String string : strs) {
            char[] c=string.toCharArray();
            Arrays.sort(c);
            String word=new String(c);
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(string);
        }
        return new ArrayList<>(map.values());
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups=new HashMap<>();
        for (String s : strs) {
            char[] chars=s.toCharArray();
            Arrays.sort(chars);

            String key=String.valueOf(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}  
