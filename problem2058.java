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

class problem2058{
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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] sol=new int[2];
        int prev=head.val;
        head=head.next;
        List<Integer> list=new ArrayList<>();
        int counter=2;
        while(head.next!=null){
            if(head.val>prev && head.val>head.next.val){
                list.add(counter);
            }
            if(head.val<prev && head.val<head.next.val){
                list.add(counter);
            }
            prev=head.val;
            head=head.next;
            counter++;
        }
        if(list.size()<2){
            sol[0]=-1;
            sol[1]=-1;
            return sol;
        }
        Collections.sort(list);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            int first=list.get(i);
            int second=list.get(i+1);
            min=Math.min(second-first,min);
        }
        sol[0]=min;
        sol[1]=list.get(list.size()-1)-list.get(0);
        return sol;
    }
}  