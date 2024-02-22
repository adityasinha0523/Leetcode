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
import java.lang.*;

class problem290{
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
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();


        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static boolean wordPattern(String pattern, String s) {
        Map<String,Character> map=new HashMap<>();
        String[] sArr=s.split(" ");
        if(sArr.length!=pattern.length()){
            return false;
        }
        Set<Character> set=new HashSet<>();
        int k=0;
        for (int i = 0; i < sArr.length; i++) {
            if(map.containsKey(sArr[i])){
                Character val=map.get(sArr[i]);
                
                if(val!=pattern.charAt(k)){
                    return false;
                }
            }else{
                if(set.contains(pattern.charAt(k))){
                    return false;
                }
                set.add(pattern.charAt(k));
                map.put(sArr[i], pattern.charAt(k) );
                
            }
            k++;
        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String s) {
        Map<String,Character> map=new HashMap<>();
        String[] s1=s.split(" ");
        Set<String> set=new HashSet<>();
        if(s1.length!=pattern.length()){
            return false;
        }
        Set<Character> setChar=new HashSet<>();
        Map<Character,String> map2=new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if(set.contains(s1[i])){
                char c=map.get(s1[i]);
                if(c!=pattern.charAt(i)){
                    return false;
                }
            }else{
                set.add(s1[i]);
                map.put(s1[i], pattern.charAt(i));
            }

            if(setChar.contains(pattern.charAt(i))){
                String s2=map2.get(pattern.charAt(i));
                if(!s2.equals(s1[i])){
                    return false;
                }
            }
            else{
                map2.put(pattern.charAt(i), s1[i]);
                setChar.add(pattern.charAt(i));
            }
        }
        return true;
    }
}  