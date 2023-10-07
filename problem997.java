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

class problem997{
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
        int[][] trust=new int[3][3];
        int n=3;
        for(int i = 0; i < 3; i++){
            for(int y = 0; y < 2; y++){
                trust[i][y] = scan.nextInt();
            }
        }
        int solution=findJudge(n,trust);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(solution);
        scan.close();
    }  

    public static int findJudge(int n, int[][] trust) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int i = 1; i <=n; i++) {
            graph.put(i,new ArrayList<>());
        }
        for (int i = 0; i < trust.length; i++) {
            int u=trust[i][0];
            int v=trust[i][1];
            graph.get(u).add(v);
        }
        int value=-1;
        for (Map.Entry<Integer,List<Integer>> mEntry : graph.entrySet()) {
            if(mEntry.getValue().size()==0){
                value= mEntry.getKey();
            }
        }
        for (Map.Entry<Integer,List<Integer>> mEntry : graph.entrySet()) {
            if(mEntry.getValue().size()>0){
                List<Integer> ll=mEntry.getValue();
                if(!ll.contains(value)){
                    return -1;
                }
            }
        }
        return value;
    }
    
}  