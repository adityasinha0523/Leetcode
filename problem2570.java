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

class problem2570{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int key=nums1[i][0];
            int val=nums1[i][1];
            if(!list.contains(key)){
                list.add(key);
            }
            map.put(key,map.getOrDefault(key, 0)+val);
        }
        for (int i = 0; i < nums2.length; i++) {
            int key=nums2[i][0];
            int val=nums2[i][1];
            if(!list.contains(key)){
                list.add(key);
            }
            if(map.containsKey(key)){
                int value=map.get(key);
                map.put(key,value+val);
            }else{
                map.put(key,map.getOrDefault(key, 0)+val);
            }
        }
        Collections.sort(list);
        int[][] sol=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            sol[i][0]=list.get(i);
            sol[i][1]=map.get(list.get(i));
        }
        return sol;
    }
}  