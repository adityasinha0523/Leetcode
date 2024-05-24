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
import java.io.StreamCorruptedException;
import java.util.*;


import java.lang.*;

class Preethi{
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
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/
        //Taking String as input.
        //String s=scan.nextLine();

        //String xValue=Integer.toBinaryString(5);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        */
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(1);
       // list.add(6);
        int sol=getMinLength(list, 6);
        System.out.println(sol);
        scan.close();
    } 
    
    public static List<List<String>> getMatch(List<List<String>> products,List<List<String>> queries){
        List<List<String>> solution=new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<String> query=queries.get(i);
            if(query.get(0)=="Type1"){
                List<String> sol=new ArrayList<>();
                String year=query.get(1);
                for (int j = 0; j < products.size(); j++) {
                    List<String> list=products.get(j);
                    if(list.get(2).equals(year)){
                        sol.add(list.get(0));
                    }
                }
                solution.add(sol);
            }else if(query.get(0)=="Type2"){
                List<String> sol=new ArrayList<>();
                String price=query.get(1);
                int price1=Integer.parseInt(price);
                for (int j = 0; j < products.size(); j++) {
                    List<String> list=products.get(j);
                    int currentPrice=Integer.parseInt(list.get(1));
                    if(currentPrice<price1){
                        sol.add(list.get(0));
                    }
                }
                solution.add(sol);
            }else{
                List<String> sol=new ArrayList<>();
                String price=query.get(1);
                int price1=Integer.parseInt(price);
                for (int j = 0; j < products.size(); j++) {
                    List<String> list=products.get(j);
                    int currentPrice=Integer.parseInt(list.get(1));
                    if(currentPrice>price1){
                        sol.add(list.get(0));
                    }
                }
                solution.add(sol);
            }
        }
        return solution;
    } 
}  