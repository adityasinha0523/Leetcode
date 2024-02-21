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
import java.sql.RowId;

class problem1291{
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

    public static List<Integer> sequentialDigits(int low, int high) {
    List<Integer> res=new ArrayList<>();
    Queue<Integer> queue=new LinkedList<>();
    for (int i = 1; i <=9; i++) {
        queue.add(i);
    }
    while(!queue.isEmpty()){
        int current=queue.remove();
        if(current>=low &&current<=high){
            res.add(current);
        }
        int lastDigit=current%10;
        if(lastDigit<9 && current*10+lastDigit+1<=high){
            queue.add(current*10+lastDigit+1);
        }
    }
    return res;
}
    public static List<Integer> sequentialDigits2(int low, int high) {
        String digits="123456789";
        List<Integer> res=new ArrayList<>();
        int nl=String.valueOf(low).length();
        int nh=String.valueOf(high).length();
        for (int i = nl; i <=nh; i++) {
            for (int j = 0; j <digits.length(); j++) {
                String s=digits.substring(j, j+i);
                int n=Integer.valueOf(s);
                if(n>=low &&n<=high){
                    res.add(n);
                }
            }
        }
        return res;
    }

    public static boolean checkSeq(int n){
        int prev=n%10;
        n=n/10;
        while(n!=0){
            int temp=n%10;
            n=n/10;
            if(temp+1!=prev){
                return false;
            }
            prev=temp;
        }
        return true;
    }
}  