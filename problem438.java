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

class problem438{
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

        //String xValue=Integer.toBinaryString(5);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        List<Integer> sol=findAnagrams("cbaebacd", "abc");
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        scan.close();
    }
    
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        List<Integer> solution=new ArrayList<>();
        int end=0;
        int start=0;
        while(end<p.length()){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                int val=map.get(c);
                val=val-1;
                map.put(c, val);
            }
            end++;
        }
        boolean found=true;
        for (Map.Entry<Character,Integer> hEntry : map.entrySet()) {
            int val=hEntry.getValue();
            if(val!=0){
                found=false;
                break;
            }
        }
        if(found==true){
            solution.add(start);
        }
        while(end<s.length()){
            char c=s.charAt(start);
            if(map.containsKey(c)){
                int val=map.get(c);
                val=val+1;
                map.put(c, val);
            }
            start++;
            char c1=s.charAt(end);
            if(map.containsKey(c1)){
                int val=map.get(c1);
                val=val-1;
                map.put(c1, val);
            }
            end++;
            boolean found1=true;
            for (Map.Entry<Character,Integer> hEntry : map.entrySet()) {
                int val=hEntry.getValue();
                if(val!=0){
                    found1=false;
                    break;
            }
            }
            if(found1==true){
                solution.add(start);
            }
        }
        return solution;
    }
}  