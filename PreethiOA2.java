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

class PreethiOA2{
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
        //System.out.println("Hello World!");
        String ss = "23511011501782351112179911801562340161171141148";
        String sol=decode(ss);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String decode(String encoded) {
        //List ans = new ArrayList();
            StringBuilder input1 = new StringBuilder(); 
            input1.append(encoded); 
        
            // reverse StringBuilder input1 
            input1 = input1.reverse(); 
        
            // print reversed String 
            //System.out.println(input1);
            encoded = input1.toString();
            
            int l = encoded.length();
            Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
            List<String> tList = new ArrayList<String>();
            tList.add("");
            map.put(l,tList);
            map.put(l+1,tList);
            
            for(int i=l-1; i>=0; i--) {
                List<String> currentList = new ArrayList<String>();
                
                if(i+2<=l) {
                    String s1 = encoded.substring(i,i+2);
                    if(isValid(s1)) {
                        char c = (char)(Integer.parseInt(s1));
                        List<String> t1 = map.get(i+2);
                        for(String s:t1) {
                            String t = c+s;
                            currentList.add(t);
                        }
                    }
                }
                
                if(i+3<= l) {
                    String s1 = encoded.substring(i,i+3);
                    if(isValid(s1)) {
                        char c = (char)(Integer.parseInt(s1));
                        List<String> t1 = map.get(i+3);
                        for(String s:t1) {
                            String t = c+s;
                            currentList.add(t);
                        }
                    }
                }
                map.put(i,currentList);
            
            }
            
            List<String> input=map.get(0);
            String inputSol=input.get(input.size()-1);
            return inputSol;
            //return map.get(0);
        
        }
    public static boolean isValid(String s) {
            int val = Integer.parseInt(s);
            return (val >=10 && val <=126);
    }        
}  