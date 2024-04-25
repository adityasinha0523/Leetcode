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

class problem2679{
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
        
        int[][] nums=new int[4][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }
        int sol=matrixSum(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int matrixSum(int[][] nums) {
        /*int solution=0;
        List<ArrayList<Integer>> listArr=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list=new ArrayList<>();
            for (int j = 0; j < nums[0].length; j++) {
                int val=nums[i][j];
                list.add(val);
            }
            Collections.sort(list);
            listArr.add(list);
        }
        for (int i = 0; i < nums[0].length; i++) {
            //int val=Integer.MIN_VALUE;
            List<Integer> l=new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int currentVal=listArr.get(j).get(i);
                l.add(currentVal);
            }
            Collections.sort(l);
            Collections.reverseOrder();
            solution+=l.get(l.size()-1);
        }
        return solution;*/
        int solution=0;
        List<List<Integer>> arrList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < nums[0].length; j++) {
                int val=nums[i][j];
                list.add(val);
            }
            Collections.sort(list);
            arrList.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int val=arrList.get(i).get(j);
                list.add(val);
            }
            Collections.sort(list);
            solution+=list.get(list.size()-1);
        }
        return solution;
    }
}  