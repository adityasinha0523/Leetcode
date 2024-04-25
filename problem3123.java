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

class problem3123{
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
    
    public static boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> e=new ArrayList<>();
        int m=edges.length;
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<>());
        }
        for(int[] x:edges){
            e.get(x[0]).add(new int[]{x[1],x[2]});
            e.get(x[0]).add(new int[]{x[0],x[2]});
        }

        long[] d1=new long[n];
        boolean[] seen=new boolean[n];
        Arrays.fill(d1, Long.MAX_VALUE);
        d1[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<>() {
            public int compare(long[] a,long[] b){
                return a[1]>b[1]?1:-1;
            }
        });
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            int curr=(int)pq.remove()[0];
            if(seen[curr]){
                continue;
            }
            for (int[] x : e.get(curr)) {
                if(d1[curr]+x[1]<d1[x[0]]){
                    d1[x[0]]=d1[curr]+x[1];
                    pq.add(new long[]{x[0],d1[x[0]]});
                }
            }
        }

        long[] d2=new long[n];
        seen=new boolean[n];
        Arrays.fill(d2, Long.MAX_VALUE);
        d2[n-1]=0;
        pq=new PriorityQueue<>(new Comparator<>() {
            public int compare(long[] a,long[] b){
                return a[1]>b[1]?1:-1;
            }
        });
        pq.add(new long[]{n-1,0});
        while(!pq.isEmpty()){
            int curr=(int)pq.remove()[0];
            if(seen[curr]){
                continue;
            }
            seen[curr]=true;
            for (int[] x : e.get(curr)) {
                if(d2[curr]+x[1]<d2[x[0]]){
                    d2[x[0]]=d2[curr]+x[1];
                    pq.add(new long[]{x[0],d2[x[0]]});
                }
            }
        }
        long min=d1[n-1];
        boolean[] ans=new boolean[m];
        for (int i = 0; i < m; i++) {
            int a=edges[i][0];
            int b=edges[i][1];
            int w=edges[i][2];
            if((long)w+d1[a]+d2[b]==min||(long)w+d1[b]+d2[w]==min){
                ans[i]=true;
            }
        }
        return ans;
    }
}  