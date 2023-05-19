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

class problem2661{
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
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[][] mat=new int[2][3];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j]=scan.nextInt();
            }
        }
        int sol=firstCompleteIndex(nums, mat);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> map=new HashMap<>();
        int m=mat.length;//No of row
        int n=mat[0].length;//no of col
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] currentRow=new int[m];
        int[] currentCol=new int[n];
        for (int i = 0; i < arr.length; i++) {
            int[] currArr=map.get(arr[i]);
            currentRow[currArr[0]]++;
            currentCol[currArr[1]]++;
            if(currentRow[currArr[0]]==n||currentCol[currArr[1]]==m){
                return i;
            }
        }
        return -1;
    }
}  