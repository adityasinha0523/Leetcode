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

class problem1122{
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
        
        int[] nums1=new int[6];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=scan.nextInt();
        }
        int[] nums2=new int[4];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
        }
        int[] sol=relativeSortArray(nums1,nums2);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        List<Integer> solution=new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int key=arr2[i];
            int value=map.get(key);
            map.put(key,0);
            for (int j = 0; j < value; j++) {
                solution.add(key);
            }
        }
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> hEntry : map.entrySet()) {
            int key=hEntry.getKey();
            int value=hEntry.getValue();
            if(value!=0){
                for (int i = 0; i < value; i++) {
                    list.add(key);
                }
            }
        }
        Collections.sort(list);
        int[] sol=new int[arr1.length];
        int k=0;
        for (int i = 0; i < solution.size(); i++) {
            sol[k++]=solution.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            sol[k++]=list.get(i);
        }
        return sol;
    }
}  
