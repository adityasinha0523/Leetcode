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
import java.util.Map.Entry;

import javax.swing.text.AbstractDocument.LeafElement;

import java.lang.*;

class Q3{
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
        
        String[][] input=new String[4][4];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                input[i][j]=scan.nextLine();
            }
        }
        //Output -->afbecd
        //Input -->abcde
        //Output -->aebdc
        String[] sol=solution(input);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] solution(String[][] laps){
        String[] solution1=new String[laps[0].length];
        Set<String> set=new HashSet<>();
        int k=0;
        for (int i = 0; i < laps.length; i++) {
            List<Integer> inputValue=new ArrayList<>(); 
            Map<Integer,String> map=new HashMap<>();
            int highestSpeed=Integer.MIN_VALUE;
            for (int j = 0; j < laps[0].length; j++) {
                String s=laps[i][j];
                String[] input=s.split(" ");
                String driverName=input[0];
                String speed=input[1];
                int speedInInt=Integer.parseInt(speed);
                map.put(speedInInt,driverName);
                //highestSpeed=Math.max(highestSpeed, speedInInt);
                inputValue.add(speedInInt);
            }
            Collections.sort(inputValue);
            Collections.reverse(inputValue);
            for (int j = 0; j < inputValue.size(); j++) {
                int key=inputValue.get(j);
                String driverName=map.get(key);
                if(!set.contains(driverName)){
                    solution1[k++]=driverName;
                    set.add(driverName);
                    break;
                }
            }
            //inputValue.clear();
            /*for (Map.Entry<String,Integer> hEntry : map.entrySet()) {
                String key=hEntry.getKey();
                int value=hEntry.getValue();
                if(value==highestSpeed && !set.contains(key)){
                    solution1[k++]=key;
                    set.add(key);
                }
            }*/
        }
        return solution1;
    }
}  