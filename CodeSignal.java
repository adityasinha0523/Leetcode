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

import javax.swing.JLabel;

import java.lang.*;

class CodeSignal{
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
        int[][] arr=new int[6][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]=scan.nextInt();
            }
        }
        int[][] sol=solution(arr);
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.println(sol[i][j]);
            }
        }
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  
    public static int[][] solution(int[][] arr){
        List<Integer> sol=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]!=0){
                    int key=arr[i][j];
                    int sideLength=key*2+1;
                    int t=sideLength/2-i;
                    int maxUp=Math.max(sideLength/2-i,0);
                    boolean maxUpVal=false;
                    if(maxUp==t){
                        maxUpVal=true;
                    }
                    int maxDown=Math.min(sideLength/2+i,arr.length-1);
                    int maxLeft=Math.max(sideLength/2-j,0);
                    int maxRight=Math.min(sideLength/2+j,arr[0].length-1);
                    boolean foundGreater=false;
                    for (int k = maxUp; k <=maxDown; k++) {
                        for (int k2 = maxLeft; k2 <=maxRight; k2++) {
                            if(k==maxUp && k2==maxLeft && maxUpVal!=true){
                                continue;
                            }
                            else if(k==maxLeft && k2==maxRight){
                                continue;
                            }else if(k==maxRight && k2==maxLeft){
                                continue;
                            }else if(k==maxRight && k2==maxRight){
                                continue;
                            }
                            else if(k2!=0){
                                if(arr[k][k2]>key){
                                    foundGreater=true;
                                }
                            } 
                        }
                    }
                    if(foundGreater==false){
                        sol.add(i);
                        sol.add(j);
                    }
                }
            }
        }
        int[][] sol1=new int[2][2];
        return sol1;
    }

}  