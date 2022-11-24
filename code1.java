import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class code1{
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
        
        int[] nums=new int[11];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=solution(nums, 4);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] solution2(int[] forest,int bird){
        int startingPoint=bird;
        List<Integer> sol=new ArrayList<>();
        boolean done=false;
        int sum=0;
        int counter=0;
        while(true){
            if(counter%2==0){
                counter++;
                for(int i=startingPoint+1;i<forest.length;i++){
                    if(forest[i]!=0){
                        sol.add(i);
                        sum+=forest[i];
                        forest[i]=0;
                        break;
                    }
                }
            }else{
                counter++;
                for (int i = startingPoint-1; i >=0; i--) {
                    if(forest[i]!=0){
                        sol.add(i);
                        sum+=forest[i];
                        forest[i]=0;
                        break;
                    }
                    forest[i]=0;
                }
            }
            if(sum>100){
                break;
            }
        }
        int size=sol.size();
        int[] solution=new int[size];
        int k=0;
        for (int i : sol) {
            solution[k++]=i;
        }
        return solution;
    }

    public static int[] solution(int[] forest,int bird){
        int startingPoint=bird;
        List<Integer> sol=new ArrayList<>();
        boolean done=false;
        int sum=0;
        int counter=0;
        Stack<Integer> stack1=new Stack<>();
        List<Integer> stack2=new ArrayList<>();
        for (int i = 0; i < forest.length; i++) {
            if(i<=startingPoint & forest[i]!=0){
                stack1.add(i);
            }else{
                if(forest[i]!=0){
                    stack2.add(i);
                }
                
            }
        }
        int second=0;
        int first=0;
        while(true){
            if(counter%2==0){
                int val=stack2.get(second++);
                sol.add(val);
                sum+=forest[val];
            }else{
                int val=stack1.pop();
                sol.add(val);
                sum+=forest[val];
            }
            if(sum>=100){
                break;
            }
            counter++;
        }
        int size=sol.size();
        int[] solution=new int[size];
        int k=0;
        for (int i : sol) {
            solution[k++]=i;
        }
        return solution;
    }
}  
