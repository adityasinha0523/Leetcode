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
import java.net.Inet4Address;

class PreethiOA{
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
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        List<Integer> c=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        List<List<Integer>> sol=new ArrayList<>();
        sol.add(a);
        sol.add(b);
        List<List<Integer>> solution=findMatrix(sol);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (List<Integer> integer : solution) {
            for (Integer list : integer) {
                System.out.println(list);
            }
            System.out.println("\n");
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<List<Integer>> findMatrix(List<List<Integer>>a){
        List<List<Integer>> returnSol=new ArrayList<>();
        int row=a.size();
        int col=a.get(0).size();
        int[][] sumIndex=new int[row][col];
        int p=0;
        int k=0;
        
        for (List<Integer> integer : a) {
            for (Integer list : integer) {
                sumIndex[p][k++]=list;
            }
            p++;
            k=0;
            //System.out.println("\n");
        }
        
        int[][] solutionIndex=new int[row][col];
        for (int i = 0; i < sumIndex.length; i++) {
            for (int j = 0; j < sumIndex[0].length; j++) {
                if(i==0){
                    if(j!=0){
                        solutionIndex[i][j]=solutionIndex[i][j-1] +sumIndex[i][j];
                    }else{
                        solutionIndex[i][j]=sumIndex[i][j];
                    }  
                }
            }
        }
        for (int i = 1; i < solutionIndex.length; i++) {
            for (int j = 0; j < solutionIndex[0].length; j++) {
                int sumOfCol=0;
                for(int k1=i-1;k1>=0;k1--){
                    sumOfCol+=sumIndex[k1][j];
                }
                if(j!=0){
                    solutionIndex[i][j]=sumIndex[i][j]+sumOfCol+solutionIndex[i][j-1];
                }else{
                    solutionIndex[i][j]=sumIndex[i][j]+solutionIndex[i-1][j];
                }
            }
        }
        for (int i = 0; i < solutionIndex.length; i++) {
            List<Integer> a1=new ArrayList<>();
            for (int j = 0; j < solutionIndex[0].length; j++) {
                a1.add(solutionIndex[i][j]);
            }
            returnSol.add(a1);
        }

        return returnSol;
    }
}  