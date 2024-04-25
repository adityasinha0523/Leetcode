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

class problem310{
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
        scan.close();
    }
    
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> myGraph=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }

        int[] degree=new int[n];
        for (int i = 0; i < n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> myQueue=new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if(degree[i]==0){
                return res;
            }
            else if(degree[i]==1){
                myQueue.add(i);
            }
        }
        while(!myQueue.isEmpty()){
            res=new ArrayList<>();
            int count=myQueue.size();
            for (int i = 0; i < count; i++) {
                int curr=myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for (int j = 0; j < myGraph.get(curr).size(); j++) {
                    int next=myGraph.get(curr).get(j);
                    if(degree[next]==0){
                        continue;
                    }
                    if(degree[next]==2){
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }
        }
        return res;
    }
}  