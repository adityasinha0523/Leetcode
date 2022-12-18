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

class problemLCContest1{
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
        
        String[] nums=new String[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        int sol=similarPairs(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int similarPairs(String[] words) {
        List<Character[]> list=new ArrayList<>();
        int solution=0;
        for (int i = 0; i < words.length; i++) {
            Character[] charArr=new Character[26];
            String s=words[i];
            for (int j = 0; j < s.length(); j++) {
                int p=s.charAt(j)-'a';
                charArr[p]=1;
            }
            list.add(charArr);
        }
        for (int i = 0; i < list.size()-1; i++) {
            Character[] input=list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                Character[] traverse=list.get(j);
                boolean check=false;
                for (int k = 0; k < traverse.length; k++) {
                    if(input[k]!=null && traverse[k]!=null){
                        //check=false;
                        continue;
                    }else if(input[k]==null && traverse[k]==null){
                        continue;
                    }else{
                        check=true;
                    }
                }
                if(check==false){
                    solution++;
                }
            }
        }
        return solution;
    }
}  