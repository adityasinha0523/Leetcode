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

class problem2120{
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
        int[] arr=new int[2];
        arr[0]=0;
        arr[1]=1;
        int[] sol=executeInstructions(3,arr , "RRDDLU");
        //Printing 1D Array.
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] sol=new int[s.length()];
        int k=0;
        int tempFirst=startPos[0];
        int tempSecond=startPos[1];
        for (int i = 0; i < s.length(); i++) {
            int counter=0;
            startPos[0]=tempFirst;
            startPos[1]=tempSecond;
            for (int j = i; j < s.length(); j++) {
                char c=s.charAt(j);
                if(c=='U'){
                    int first=startPos[0];
                    int second=startPos[1];
                    //first=first-1;
                    first=first-1;
                    if(first>=0 && first<n &&second>=0 && second<n){
                        counter++;
                        startPos[0]=first;
                        startPos[1]=second;
                    }else{
                        break;
                    }
                }
                else if(c=='D'){
                    int first=startPos[0];
                    int second=startPos[1];
                    first=first+1;
                    if(first>=0 && first<n &&second>=0 && second<n){
                        counter++;
                        startPos[0]=first;
                        startPos[1]=second;
                    }else{
                        break;
                    }
                }else if(c=='L'){
                    int first=startPos[0];
                    int second=startPos[1];
                    second=second-1;
                    if(first>=0 && first<n &&second>=0 && second<n){
                        counter++;
                        startPos[0]=first;
                        startPos[1]=second;
                    }else{
                        break;
                    }
                }else{
                    //Right
                    int first=startPos[0];
                    int second=startPos[1];
                    second=second+1;
                    if(first>=0 && first<n &&second>=0 && second<n){
                        counter++;
                        startPos[0]=first;
                        startPos[1]=second;
                    }else{
                        break;
                    }
                }
            }
            sol[k++]=counter;
        }
        return sol;
    }
}  