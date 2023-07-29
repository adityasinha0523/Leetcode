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

class problem1940{
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
        

        //Taking String as input.
        //String s=scan.nextLine();

        //List<Integer> sol=longestCommonSubsequence(arr);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> longestCommonSubsequence(int[][] arrays) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int integer : arrays[i]) {
                map.put(integer, map.getOrDefault(integer, 0)+1);
            }
        }
        for (Map.Entry<Integer,Integer> hmap : map.entrySet()) {
            int val=hmap.getValue();
            int key=hmap.getKey();
            if(val==arrays.length){
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}  