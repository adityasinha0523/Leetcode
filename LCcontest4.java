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

class LCcontest4{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        int[] sol=closestPrimes(4, 6);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol[0]);
        System.out.println(sol[1]);
        scan.close();
    }  

    public static int[] closestPrimes(int left, int right) {
        List<Integer> list=new ArrayList<>();
        int[] sol=new int[2];
        for (int i = left; i <=right; i++) {
            if(isPrime(i)){
                if(list.size()!=0){
                    int first=list.get(list.size()-1);
                    if(sol[1]!=0){
                        int prevMin=sol[1]-sol[0];
                        int currentMin=i-first;
                        if(currentMin<prevMin){
                            sol[0]=list.get(list.size()-1);
                            sol[1]=i;
                            list.add(i);
                        }
                    }else{
                        sol[1]=i;
                        list.add(i);
                    }
                    
                }
                else{
                    sol[0]=i;
                    list.add(i);
                }
            }
        }
        if(sol[0]==0||sol[1]==0){
            sol[0]=-1;
            sol[1]=-1;
        }
        return sol;
    }

    public static boolean isPrime(int n)
	{
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
}  