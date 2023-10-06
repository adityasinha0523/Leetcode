package Notes;
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
public class BFSTraversalGraph {
    public static void main(String[] args) {
        
    }

    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  // creating adjacent list
        int n = edges.length+1;     // max range of the element present in the edge array
        
        // initializing adjacency list with new ArrayList
        for(int i=0 ; i<=n ; i++){
            adjList.add(new ArrayList<>());
        }
        
        
        // filling the elements from edges array into the adjacency list
        for(int i=0 ; i<n-1 ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }
        
        
        // Queue data structure for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // adding first element into the queue
        q.offer(edges[0][0]);
        
        
        // while there is an element present in the queue
        while(!q.isEmpty()){
            int currNode = q.poll();    // current visiting node
            int countAdj = 0;   // variable for counting the adjacent nodes
            
            // visiting adjacent nodes of the current node
            for(int adjNode : adjList.get(currNode)){
                    q.offer(adjNode);   // adding adjacent node into the queue
                    countAdj++;     // increment the countAdj variable
                    if(countAdj==n-1){
                        return currNode;
                    }

            }
        }
        return -1;
    }
}
