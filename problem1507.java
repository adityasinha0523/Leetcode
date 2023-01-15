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

class problem1507{
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
        String sol=reformatDate("26th May 1960");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String reformatDate(String date) {
        Map<String,Integer> hMap=new HashMap<>();
        hMap.put("Jan", 1);
        hMap.put("Feb", 2);
        hMap.put("Mar", 3);
        hMap.put("Apr", 4);
        hMap.put("May", 5);
        hMap.put("Jun", 6);
        hMap.put("Jul", 7);
        hMap.put("Aug", 8);
        hMap.put("Sep", 9);
        hMap.put("Oct", 10);
        hMap.put("Nov", 11);
        hMap.put("Dec", 12);
        String[] stringArr=date.split(" ");
        StringBuilder sb= new StringBuilder();
        for (int i = stringArr.length-1; i >=0; i--) {
            String s=stringArr[i];
            if(i==stringArr.length-1){
                sb.append(s);
                sb.append("-");
            }
            else if(i==stringArr.length-2){
                if(s.equals("Oct")||s.equals("Nov")
                ||s.equals("Dec")){
                    sb.append(hMap.get(s));
                }else{
                    sb.append("0");
                    sb.append(hMap.get(s));
                }
                sb.append("-");
            }else{
                if(Character.isDigit(s.charAt(1))){
                    sb.append(s.charAt(0));
                    sb.append(s.charAt(1));
                }else{
                    sb.append("0");
                    sb.append(s.charAt(0));
                }
            }
        }
        return sb.toString();
    }
}  