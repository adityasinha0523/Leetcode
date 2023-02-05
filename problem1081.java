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

class problem1081{
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

    public static String smallestSubsequence(String s) {
        List<String> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            StringBuilder sb=new StringBuilder();
            Set<Character> set=new HashSet<>();
            sb.append(s.charAt(i));
            set.add(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                    sb.append(s.charAt(j));
                }
            }
            if(sb.length()>max){
                list.clear();
                list.add(sb.toString());
            }else if(sb.length()==max){
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        String sol=list.get(0);
        char charArray[] = sol.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sc=new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sc.append(charArray[i]);
        }
        return sc.toString();
    }
}  