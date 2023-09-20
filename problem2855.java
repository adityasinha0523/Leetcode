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

class problem2855{
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
        List<Integer> nums=new ArrayList<>();
        nums.add(31);
        nums.add(72);
        nums.add(79);
        nums.add(25);
        //nums.add(2);
        int sol=minimumRightShifts(nums);
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

    public static int minimumRightShifts(List<Integer> nums) {
        int[] sortedArr=new int[nums.size()];
        int k=0;
        for (Integer integer : nums) {
            sortedArr[k++]=integer;
        }
        Arrays.sort(sortedArr);
        int sol=0;
        int i=0;
        while(true){
            if(sortedArr[0]==nums.get(i)){
                if(i==0){
                    sol=0;
                }else{
                    sol=nums.size()-i;
                }
                break;
            }
            i++;
        }
        int counter=1;
        int temp=(i+1)%nums.size();
        while(counter!=nums.size()){
            if(sortedArr[counter]!=nums.get(temp)){
                return -1;
            }
            counter++;
            temp=(temp+1)%nums.size();
        }
        return sol;
    }
}  