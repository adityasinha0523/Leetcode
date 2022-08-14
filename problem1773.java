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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class problem1773{
    

    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[4];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        List<List<String>> items=new ArrayList<List<String>>();
        List<String> l1 = new ArrayList<String>();
        l1.add("phone");
        l1.add("blue");
        l1.add("pixel");
        items.add(l1);
        List<String> l2 = new ArrayList<String>();
        l2.add("computer");
        l2.add("silver");
        l2.add("lenovo");
        List<String> l3 = new ArrayList<String>();
        l3.add("phone");
        l3.add("silverr");
        l3.add("lenqeqweqweovo");
        items.add(l2);
        items.add(l3);
        String ruleKey ="type";
        String ruleValue ="phone";
        int sol=countMatches(items,ruleKey,ruleValue);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int solution=0;
        if(ruleKey.equals("type")){
            for (List<String> list : items) {
                if(list.get(0).equals(ruleValue)){
                    solution++;
                }
            }
        }else if(ruleKey.equals("color")){
            for (List<String> list : items) {
                if(list.get(1).equals(ruleValue)){
                    solution++;
                }
            }
        }else{
            for (List<String> list : items) {
                if(list.get(2).equals(ruleValue)){
                    solution++;
                }
            }
        }
        return solution;
    }
}  