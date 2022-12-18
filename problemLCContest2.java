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

class problemLCContest2{
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
        
        int n=4;
        int sol=smallestValue(n);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int smallestValue(int n) {
        int number=n;
        while(true){
            int initialNumber=number;
            Boolean divideByNo=false;
            List<Integer> list=new ArrayList<>();
            int half=number/2;
            for (int i = 2; i <=half; i++) {
                if(number==1){
                    break;
                }
                boolean checkPrime=isPrime(i);
                if(checkPrime){
                    while(true){
                        if(number%i==0){
                            divideByNo=true;
                            list.add(i);
                            number=number/i;
                        }else{
                            break;
                        }
                    }
                }
            }
            
            int sum=0;
            for (int i = 0; i < list.size(); i++) {
                sum+=list.get(i);
            }
            if(divideByNo==false){
                break;
            }
            if(sum==initialNumber){
                number=sum;
                break;
            }
            number=sum;
        }
        return number;
    }
    public static boolean isPrime(int n)
    {
    // Corner cases
    if (n <= 1)
    return false;
    if (n <= 3)
    return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}  