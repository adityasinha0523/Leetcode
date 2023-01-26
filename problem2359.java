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

import javax.print.attribute.standard.NumberUpSupported;

import java.lang.*;

class problem2359{
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
        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=closestMeetingNode(nums, 0, 1);
        System.out.println(sol);
        scan.close();
    }  

    public static void dfs(int node, int[] edges, int[] distance, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            distance[neighbor] = distance[node] + 1;
            dfs(neighbor, edges, distance, visited);
        }
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int ans = -1;
        int minDist = Integer.MAX_VALUE;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        for (int currNode = 0; currNode < n; currNode++) {
            if (visited1[currNode] && visited2[currNode] && minDist > Math.max(dist1[currNode], dist2[currNode])) {
                minDist = Math.max(dist1[currNode], dist2[currNode]);
                ans = currNode;
            }
        }
        return ans;
    }

    public static int closestMeetingNode2(int[] edges, int node1, int node2) {
        int minDist=Integer.MAX_VALUE;
        int n=edges.length;
        boolean[] visited1=new boolean[n];
        boolean[] visited2=new boolean[n];
        int[] distance1=new int[n];
        int[] distance2=new int[n];
        int ans=-1;
        dfs2(node1,edges,distance1,visited1);
        dfs2(node2, edges, distance2, visited2);
        int currNode=0;
        for (currNode = 0; currNode < n; currNode++) {
            if(visited1[currNode] && visited2[currNode] && minDist>Math.max(distance1[currNode], distance2[currNode])){
                minDist=Math.max(distance1[currNode], distance2[currNode]);
                ans=currNode;
            }
        }
        return ans;
    }

    public static void dfs2(int node, int[] edges, int[] distance, boolean[] visited) {
        visited[node]=true;
        int neighbor=edges[node];
        if(neighbor!=-1 && visited[neighbor]!=true){
            distance[neighbor]=distance[node]+1;
            dfs2(neighbor, edges, distance, visited);
        }
    }
}  