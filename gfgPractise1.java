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

class gfgPractise1{
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
    static boolean[] visited;
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited=new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            if(!visited[i] && checkBfs(adj.get(i),i,adj,V)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkBfs(List<Integer> list,int i,ArrayList<ArrayList<Integer>> adj,int V){
        
        Queue<Integer> queue=new LinkedList<>();
        int[] parent=new int[V];
        Arrays.fill(parent, -1);
        visited[i]=true;
        queue.add(i);
        while(!queue.isEmpty()){
            int u=queue.poll();
            List<Integer> list2=adj.get(u);
            for (int j = 0; j < list2.size(); j++) {
                int v=list2.get(j);
                if(!visited[v]){
                    queue.add(v);
                    parent[v]=u;
                    visited[v]=true;
                }else if(parent[u]!=v){
                    return true;
                }
            }
        }
        return false;
        //queue.add(arr);
        //visited[i]=true;
        /*for (int j = 0; j < list.size(); j++) {
            int val=list.get(j);
            arr[0]=val;
            arr[1]=i;
            queue.add(arr);
        }*/
        /*while(!queue.isEmpty()){
            arr=queue.poll();
            List<Integer> l2=adj.get(arr[0]);
            for (int j = 0; j < l2.size(); j++) {
                if(visited[l2.get(j)]==false){
                    visited[l2.get(j)]=true;
                    arr[0]=l2.get(j);
                    arr[1]=i;
                    queue.add(arr);
                }else if(l2.get(j)!=arr[1]){
                    return true;
                }
            }
        }
        for (int j = 0; j < visited.length; j++) {
            visited[i]=false;
        }
        return false;*/
    }
}  