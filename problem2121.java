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

class problem2121{
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

    public static long[] getDistances(int[] arr) {
        long[] solution=new long[arr.length];
        int[] freq=new int[100001];
        Map<Integer,Long> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int el=arr[i];
            if(!map.containsKey(el)){
                map.put(el,0l);
            }
            solution[i]+=i*(long)freq[el]-map.get(el); 
            
            map.put(el,map.get(el)+i);
            freq[el]++;
        }
        map=new HashMap<>();
        freq=new int[100001];
        for (int i =arr.length-1; i>=0; i--) {
            int el=arr[i];
            if(!map.containsKey(el)){
                map.put(el,0l);
            }
            solution[i]+=map.get(el)- (i)*(long)freq[el]; 
            
            map.put(el,map.get(el)+i);
            freq[el]++;
        }
        return solution;
    }
}  