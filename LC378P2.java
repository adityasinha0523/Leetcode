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

class LC378P2{
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

    int sol=maximumLength("abcaba");
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
        System.out.println(sol);
        scan.close();
    }  

    
    public static int maximumLength(String s) {
        Map<String ,Integer> map=new HashMap<>();
        int solution=0;
        int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            int val=s.charAt(i)-'a';
            arr[val]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(arr[c-'a']<3){
                continue;
            }
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(j)==c){
                    sb.append(s.charAt(j));
                    map.put(sb.toString(),map.getOrDefault(sb.toString(), 0)+1);
                }else{
                    break;
                }
            }
        }    
            for (Map.Entry<String,Integer> mEntry : map.entrySet()) {
                String s1=mEntry.getKey();
                int value=mEntry.getValue();
                if(value>=3){
                    solution=Math.max(s1.length(), solution);
                }
            }
        
        return solution==0?-1:solution;
    }
    
}  