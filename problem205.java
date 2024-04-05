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

class problem205{
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
        String s="badc";
        String t="baba";
        boolean sol=isIsomorphic(s, t);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean isIsomorphic2(String s, String t) {
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first=s.charAt(i);
            char second=t.charAt(i);
            if(map1.containsKey(first)){
                char valueFirst=map1.get(first);
                if(valueFirst!=second){
                    return false;
                }
            }else{
                map1.put(first, second);
            }
            if(map2.containsKey(second)){
                char valueSecond=map2.get(second);
                if(valueSecond!=first){
                    return false;
                }
            }else{
                map2.put(second, first);
            }
        }
        return true;
    }





    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char key=s.charAt(i);
            char value=t.charAt(i);
            if(map.containsKey(key)){
                char mapValue=map.get(key);
                if(Character.compare(mapValue, value) !=0){
                    return false;
                }
            }else if(map2.containsKey(value)){
                char mapValue2=map2.get(value);
                if(Character.compare(mapValue2, key)!=0){
                    return false;
                }
            }
            else{
                map.put(key, value);
                map2.put(value,key);
            }
        }
        return true;
    }
}  
