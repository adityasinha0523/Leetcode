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

class problem210{
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

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList=new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree=new int[prerequisites.length];
        for (int i = 0; i < prerequisites.length; i++) {
            int first=prerequisites[i][0];
            int second=prerequisites[i][1];
            adjList.get(second).add(first);
            indegree[first]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] sol=new int[prerequisites.length];
        int k=0;
        while(!q.isEmpty()){
            int val=q.poll();
            sol[k++]=val;
            for (int i : adjList.get(val)) {
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return sol;
    }
}  