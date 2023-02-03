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

class problem923{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int threeSumMulti(int[] arr, int target) {
        int solution=0;
        int mod=(int)1e9+7;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int value=arr[i];
            int first=i+1;
            int last=arr.length-1;
            while(first<last){
                if(value+arr[first]+arr[last]==target){
                    if(arr[first]==arr[last])
                    {
                        int n=last-first+1;
                        int m=n*(n-1);
                        m/=2;
                        solution+=m;
                        break;
                    }
                    else{
                    int re=0,le=0,n=arr[first],m=arr[last];
                    while(first<=last &&arr[first]==n)
                    {
                        le++;
                        first++;
                    }
                    while(last>=first && m==arr[last])
                    {
                        re++;
                        last--;
                    }
                    int tmpans=re*le;
                    solution+=tmpans;
                    }
                }
                else if(value+arr[first]+arr[last]<target){
                    first++;
                }else{
                    last--;
                }
            }
        }
        solution=solution%mod;
        return (int)solution;
    }
}  