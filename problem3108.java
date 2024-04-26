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

class problem3108{
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

    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU uf=new DSU(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        int[] result=new int[query.length];
        for (int i = 0; i < query.length; i++) {
            result[i]=uf.minimumCost(query[i][0], query[i][1]);
        }
        return result;
    }
}

class DSU{
    int[] parent,rank,weights;
    public DSU(int n){
        parent=new int[n];
        rank=new int[n];
        weights=new int[n];
        Arrays.fill(weights, 131071);
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }

    public int find(int x){
        if(x!=parent[x]){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y,int weight){
        int xx=find(x);
        int yy=find(y);
        if(rank[xx]<rank[yy]){
            parent[xx]=yy;
        }else{
            parent[yy]=xx;
        }
        weights[xx]=weights[yy]=weights[xx] &weights[yy]&weight;
        if(rank[xx]==rank[yy]){
            rank[xx]++;
        }
    }

    public int minimumCost(int x,int y){
        if(x==y){
            return 0;
        }
        if(find(x)!=find(y)){
            return -1;
        }
        return weights[find(x)];
    }
}