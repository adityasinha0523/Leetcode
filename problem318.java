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

class problem318{
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

        //String xValue=Integer.toBinaryString(5);
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
        //System.out.println(sol);
        scan.close();
    }  

    public static int maxProduct(String[] words) {
        int[][] arr=new int[26][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index=words[i].charAt(j)-'a';
                arr[index][i]++;
            }
        }
        int solution=0;
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                boolean different=true;
                for (int j2 = 0; j2 < 26; j2++) {
                    if(arr[j2][j]==0 &&arr[j2][i]==0){
                        continue;
                    }
                    if(arr[j2][j]>0 && arr[j2][i]>0){
                        different=false;
                        break;
                    }
                }
                if(different){
                    int count1=0;
                    int count2=0;
                    for (int k = 0; k < 26; k++) {
                        if(arr[k][i]>0){
                            count1+=arr[k][i];
                        }
                        if(arr[k][j]>0){
                            count2+=arr[k][j];
                        }
                    }
                    solution=Math.max(solution, count1*count2);
                }
            }
        }
        return solution;
    }
}  