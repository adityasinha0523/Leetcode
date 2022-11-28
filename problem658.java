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

class problem658{
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
        
        int[] nums=new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        List<Integer> sol=findClosestElements(nums, 4, 3);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : sol) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        HashMap<Integer,Integer> hMap=new HashMap<>();
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i],countMap.getOrDefault(arr[i], 0)+1);
        }
        List<Integer> sol=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            hMap.put(arr[i], Math.abs(arr[i]-x));
        }
        PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey()-b.getKey():a.getValue()-b.getValue());
        pq.addAll(hMap.entrySet());
        while(k!=0 && pq.size()!=0){
            Map.Entry<Integer,Integer> p=pq.poll();
            int key=p.getKey();
            int value=countMap.get(key);
            for (int i = 0; i < value; i++) {
                if(k!=0){
                    sol.add(key);
                    k--;
                }
                
            }
        }
        Collections.sort(sol);
        return sol;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]==a[1]?a[0]-b[0]:b[1]-a[1]);
        for (int i = 0; i < arr.length; i++) {
            if(pq.size()==k){
                if(Math.abs(arr[i]-x)<Math.abs(pq.peek()[1])){
                    pq.poll();
                    pq.add(new int[]{i,Math.abs(x-arr[i])});
                }
            }
            else{
                pq.add(new int[]{i,Math.abs(arr[i]-x)});
            }
        }
        List<Integer> sol=new ArrayList<>();
        int size=pq.size();
        for (int i = 0; i < size; i++) {
            sol.add(arr[pq.poll()[0]]);
        }
        Collections.sort(sol);
        return sol;
    }
}  