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

class problem2231{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
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
        int sol=largestInteger(65875);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int largestInteger(int num) {
        List<Integer> oddList=new ArrayList<>();
        List<Integer> evenList=new ArrayList<>();
        List<Integer> number=new ArrayList<>();
        while(num>0){
            int temp=num%10;
            if(temp%2==0){
                evenList.add(temp);
            }else{
                oddList.add(temp);
            }
            number.add(temp);
            num=num/10;
        }
        Collections.sort(oddList);
        Collections.sort(evenList);
        int multiply=1;
        int solution=0;
        int odd=0;
        int even=0;
        for (int i = 0; i < number.size(); i++) {
            if(number.get(i)%2==0){
                solution+=multiply*evenList.get(even);
                even++;
            }else{
                solution+=multiply*oddList.get(odd);
                odd++;
            }
            multiply*=10;
        }
        return solution;
    }
}  