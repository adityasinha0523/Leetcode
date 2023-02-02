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

class SauravCodeSignal{
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
        
        int[] state=new int[10];
        for (int i = 0; i < state.length; i++) {
            state[i]=scan.nextInt();
        }
        String[] operation=new String[32];
        operation[0]="C0";
        operation[1]="C2";
        operation[2]="C0";
        operation[3]="L";
        operation[4]="C7";
        operation[5]="C9";
        operation[6]="L";
        operation[7]="L";
        operation[8]="L";
        operation[9]="L";
        operation[10]="C0";
        operation[11]="C1";
        operation[12]="C2";
        operation[13]="C3";
        operation[14]="C4";
        operation[15]="C4";
        operation[16]="C5";
        operation[17]="C6";
        operation[18]="C7";
        operation[19]="C8";
        operation[20]="C9";
        operation[21]="L";
        operation[22]="L";
        operation[23]="L";
        operation[24]="L";
        operation[25]="L";
        operation[26]="L";
        operation[27]="L";
        operation[28]="L";
        operation[29]="L";
        operation[30]="C9";
        operation[31]="L";

        String sol=solution(state, operation);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  


    public static String solution(int[] state,String[] operation){
        StringBuilder sb=new StringBuilder();
        Set<Integer> set=new HashSet<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i = 0; i < state.length; i++) {
            if(state[i]==0){
                set.add(i);
                pq.add(i);
            }
        }
        for (int i = 0; i < operation.length; i++) {
            String s=operation[i];
            if(s.equals("L")){
                if(!pq.isEmpty()){
                    int key=pq.poll();
                    set.remove(key);
                    state[key]=1;
                }
                
            }else{
                int index=Integer.parseInt(s.substring(1));
                if(!set.contains(index)){
                    state[index]=0;
                    pq.add(index);
                    set.add(index);
                }
            }
        }
        for (int i = 0; i < state.length; i++) {
            String s=String.valueOf(state[i]);
            sb.append(s);
        }
        return sb.toString();
    }
}  