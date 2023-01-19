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

class problem1807{
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
        List<List<String>> knowledge=new ArrayList<>();
        List<String> l1=new ArrayList<>();
        l1.add("nam");
        l1.add("bob");
        knowledge.add(l1);
        List<String> l2=new ArrayList<>();
        l2.add("ae");
        l2.add("two");
        knowledge.add(l2);
        String sol=evaluate("(name)is(age)yearsold", knowledge);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder solution=new StringBuilder();
        Map<String, String> map = new HashMap<>();        
        for(List<String> list: knowledge) {
            map.put(list.get(0), list.get(1));
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                int k=i+1;
                StringBuilder sb=new StringBuilder();
                while(true){
                    if(s.charAt(k)==')'){
                        break;
                    }else{
                        sb.append(s.charAt(k));
                        k++;
                    }
                }
                /*for (List<String> list : knowledge) {
                    String key=list.get(0);
                    String value=list.get(1);
                    if(sb.toString().equals(key)){
                        solution.append(value);
                        i=k;
                        break;
                    }
                }*/
                solution.append(map.getOrDefault(sb.toString(), "?"));
                i=k;
            }else if(Character.isAlphabetic(s.charAt(i))){
                solution.append(s.charAt(i));
            }
        }
        return solution.toString();
    }
}  