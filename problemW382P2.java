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

class problemW382P2{
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
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
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

        int sol=maximumLength(nums);
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

    public static int maximumLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int solution=0;
        for (int i = 0; i < nums.length; i++) {
            int value=nums[i];
            int tempSol=0;
            if(value==1){
                continue;
            }
            if(map.get(value)>=1){
                tempSol+=1;
                while(value!=1){
                    int value1=(int)Math.sqrt(value);
                    if((value1*value1)==value){
                        if(map.containsKey(value1) &&map.get(value1)>=2){
                            tempSol+=2;
                        }
                        else{
                            break;
                        }
                        value=value1;
                    }
                    else{
                        break;
                    }
                }
                solution=Math.max(solution, tempSol);
            }
        }
        if(map.containsKey(1)){
            if(map.get(1)%2==0){
                solution=Math.max(solution, map.get(1)-1);
            }else{
                solution=Math.max(solution, map.get(1));
            }
            //solution=Math.max(solution, map.get(1));
        }
        return solution;
    }
}  