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

class problem347{
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
        
        int[] nums=new int[1];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=topKFrequent(nums, 1);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());
        int[] solution=new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer,Integer> val=maxHeap.poll();
            int key=val.getKey();
            solution[i]=key;
        }
        return solution;
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
            (a,b)->b.getValue()-a.getValue());
        
        for(Map.Entry<Integer,Integer> hEntry:hMap.entrySet()){
            pq.add(hEntry);
        }
        List<Integer> res=new ArrayList<>();
        int[] sol=new int[k];
        int count=0;
        while(count<k){
            Map.Entry<Integer,Integer> h=pq.poll();
            //res.add(h.getKey());
            sol[count++]=h.getKey();
        }

        return sol;
    }
    public static int[] topKFrequent2(int[] nums, int k) {
        int[] sol=new int[k];
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for (Map.Entry<Integer,Integer> entry : hMap.entrySet()) {
            pq.add(entry);
        }
        int count=0;
        while(count<k){
            Map.Entry<Integer,Integer> map=pq.poll();
            sol[count++]=map.getKey();
        }
        return sol;
    }
}  
