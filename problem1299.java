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

class problem1299{
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
    
    public static int[] replaceElements2(int[] arr) {
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        list.add(arr.length-1);
        for (int i = arr.length-2; i >=0; i--) {
            int val=list.get(list.size());
            if(val<arr[i]){
                list.add(arr[i]);
            }else{
                list.add(val);
            }
        }
        int[] answer=new int[arr.length];
        int k=0;
        for (int i = answer.length-1; i >=0; i--) {
            answer[i]=list.get(k++);
        }
        return answer;
    }

    public static int[] replaceElements(int[] arr) {
        int[] sol=new int[arr.length];
            sol[arr.length-1]=-1;
            for (int i = arr.length-2; i >=0; i--) {
                int val=arr[i];
                sol[i]=Math.max(sol[i+1],arr[i+1]);
            }
            return sol;
    }
}  