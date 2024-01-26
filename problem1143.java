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

class problem1143{
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
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        scan.close();
    }  
    public static int longestCommonSubsequence(String text1, String text2) {
        Map<String,Integer> map=new HashMap<>();
        int sol= lcsDP(text1,text2,text1.length(),text2.length(),map);
        return sol;
    }

    public static int lcsDP(String text1, String text2, int n, int m, Map<String, Integer> map) {
        // base case
        /*if (n == 0 || m == 0)
            return 0;
        
        String key = n + "," + m;
        
        if (map.containsKey(key))
            return map.get(key);
        
        int lcs = 0;
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            lcs = 1 + lcsDP(text1, text2, n - 1, m - 1, map);
        } else {
            lcs = Math.max(lcsDP(text1, text2, n - 1, m, map), lcsDP(text1, text2, n, m - 1, map));
        }
        
        map.put(key, lcs);
        
        return lcs;*/

        if(n==0 ||m==0){
            return 0;
        }
        String key=n+","+m;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int lcs=0;
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            lcs= 1+lcsDP(text1, text2, n-1, m-1, map);
        }else{
            lcs= Math.max(lcsDP(text1,text2,n-1,m,map),lcsDP(text1, text2, n, m-1, map));
        }
        map.put(key,lcs);
        return lcs;
    }
}  
