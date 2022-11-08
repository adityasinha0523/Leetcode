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

class problem1200{
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
        //scan.nextLine();
        //To take int array as input
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minValue=Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> solution=new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            int first=arr[i];
            int seconde=arr[i+1];
            minValue=Math.min(minValue, seconde-first);
        }
        for (int i = 0; i < arr.length; i++) {
            int first=arr[i];
            int seconde=arr[i+1];
            if((seconde-first)==minValue){
                List<Integer> list=new ArrayList<>();
                list.add(first);
                list.add(seconde);
                solution.add(list);
            }
        }
        return solution;
    }
}  