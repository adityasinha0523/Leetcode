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

class LCCOntestDec2{
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
        int[] nums=new int[1];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }

        int[] nums1=new int[1];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=scan.nextInt();
        }
        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=maximizeSquareArea(6,7,nums,nums1);
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
        System.out.println(sol);
        scan.close();
    }  

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod=1000000007;
        int maxSquareArea = -1;
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for (int i = 0; i < vFences.length; i++) {
            list2.add(vFences[i]);
            set2.add(vFences[i]);
        }
        list2.add(n);
        list2.add(1);
        set2.add(n);
        set2.add(1);
        Collections.sort(list2);
        for (int i = 0; i < hFences.length; i++) {
            list1.add(hFences[i]);
            set1.add(hFences[i]);
        }
        list1.add(m);
        list1.add(1);
        set1.add(m);
        set1.add(1);
        Collections.sort(list1);
        if(n>m){
            for (int i = 0; i < list1.size(); i++) {
                int val=list1.get(i);
                if(set2.contains(val)){
                    val=val-1;
                    maxSquareArea=Math.max(maxSquareArea, (val*val));
                    maxSquareArea=maxSquareArea%mod;
                }
            }
        }
        else{
            for (int i = 0; i < list2.size(); i++) {
                int val=list2.get(i);
                if(set1.contains(val)){
                    val=val-1;
                    maxSquareArea=Math.max(maxSquareArea, (val*val));
                    maxSquareArea=maxSquareArea%mod;
                }
            }
        }
        return maxSquareArea%mod==0?-1:maxSquareArea;
    }

    /*private static int[] addBoundaryFences(int[] fences, int boundary) {
        int[] newFences = new int[fences.length + 2];
        System.arraycopy(fences, 0, newFences, 1, fences.length);
        newFences[0] = 0;
        newFences[newFences.length - 1] = boundary;
        return newFences;
    }*/
}  