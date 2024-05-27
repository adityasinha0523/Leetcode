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

class problem733{
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
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q=new LinkedList<>();
        int[] arr=new int[2];
        arr[0]=sr;
        arr[1]=sc;
        q.add(arr);
        int valuee=image[sr][sc];
        image[sr][sc]=color;
        boolean[][] visited=new boolean[image.length][image[0].length];
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int[] val=q.poll();
                int first=val[0];
                int second=val[1];
                if((first-1)>=0  && image[first-1][second]==valuee &&!visited[first-1][second]){
                    int[] arr1=new int[2];
                    arr1[0]=first-1;
                    arr1[1]=second;
                    image[first-1][second]=color;
                    visited[first-1][second]=true;
                    q.add(arr1);
                }
                if((first+1)<image.length && image[first+1][second]==valuee &&!visited[first+1][second]){
                    int[] arr1=new int[2];
                    arr1[0]=first+1;
                    arr1[1]=second;
                    image[first+1][second]=color;
                    visited[first+1][second]=true;
                    q.add(arr1);
                }
                if((second+1)<image[0].length && image[first][second+1]==valuee && !visited[first][second+1]){
                    int[] arr1=new int[2];
                    arr1[0]=first;
                    arr1[1]=second+1;
                    image[first][second+1]=color;
                    visited[first][second+1]=true;
                    q.add(arr1);
                }
                if((second-1)>=0 && image[first][second-1]==valuee && !visited[first][second-1]){
                    int[] arr1=new int[2];
                    arr1[0]=first;
                    arr1[1]=second-1;
                    image[first][second-1]=color;
                    visited[first][second-1]=true;
                    q.add(arr1);
                }
            }
        }
        return image;
    }
}  