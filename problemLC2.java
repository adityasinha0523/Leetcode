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

class problemLC2{
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
        
        int[][] nums=new int[3][4];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }
        int[][] sol=sortTheStudents(nums, 2);
        for(int i=0;i<sol.length;i++){
            System.out.println("Start");
            for (int j = 0; j < sol[0].length; j++) {
                System.out.println(sol[i][j]);
            }
            System.out.println("End");
        }
        
        //System.out.println(sol);
        scan.close();
    }  

    public static int[][] sortTheStudents(int[][] score, int k) {
        List<List<Integer>> sol=new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            List<Integer> sol1=new ArrayList<>();
            for (int j = 0; j < score[0].length; j++) {
                sol1.add(score[i][j]);
            }
            sol.add(sol1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i][k],i);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq1 = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        pq1.addAll(map.entrySet());
        List<List<Integer>> solution=new ArrayList<>();
        while (!pq1.isEmpty()) {
            Map.Entry e = pq1.poll();
            int value=(int) e.getValue();
            int key=(int) e.getKey();
            List<Integer> l1=new ArrayList<>(sol.get(value));
            solution.add(l1);
        }
        int[][] finalSol=new int[score.length][score[0].length];
        for (int i = 0; i < finalSol.length; i++) {
            for (int j = 0; j < finalSol[0].length; j++) {
                finalSol[i][j]=solution.get(i).get(j);
            }
        }
        return finalSol;
    }
}  