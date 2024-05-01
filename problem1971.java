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

class problem1971{
    
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        int n=scan.nextInt();
        int source=scan.nextInt();
        int destination=scan.nextInt();
        int[][] edges=new int[5][2];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                edges[i][j]=scan.nextInt();
            }
        }
        //boolean sol=validPath(n,edges,source,destination);
        
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    } 
    boolean found=false; 
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited=new boolean[n];
        dfs(graph,visited,source,destination);
        return found;
    }

    public void dfs(Map<Integer,List<Integer>> graph,boolean[] visited,int source,int destination){
        if(visited[source]||found){
            return;
        }
        visited[source]=true;
        List<Integer> val=graph.get(source);
        for (int i = 0; i < val.size(); i++) {
            if(val.get(i)==destination){
                found=true;
                break;
            }
            if(!visited[val.get(i)]){
                dfs(graph,visited,val.get(i),destination);
            }
        }
    }
}  