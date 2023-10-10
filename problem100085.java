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

class problem100085{
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
        List<Integer> process=new ArrayList<>();
        List<Integer> task=new ArrayList<>();
        process.add(8);
        process.add(10);
        //[2,2,3,1,8,7,4,5]
        task.add(2);
        task.add(2);
        task.add(3);
        task.add(1);
        task.add(8);
        task.add(7);
        task.add(4);
        task.add(5);
        int sol=minProcessingTime(process, task);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        Collections.sort(processorTime);
        int minTime=0;
        int k=0;
        int time=0;
        int counter=0;
        for (int i = tasks.size()-1; i >= 0; i--) {
            counter++;
            if(counter==4){
                int time1=tasks.get(i)+processorTime.get(k);
                time=Math.max(time,time1);
                minTime=Math.max(minTime,time);
                counter=0;
                k++;
            }else{
                int time1=tasks.get(i)+processorTime.get(k);
                time=Math.max(time,time1);
            }
        }
        return minTime;
    }
}  