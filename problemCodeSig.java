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
import java.net.Inet4Address;

class problemCodeSig{
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
        
        int[] nums=new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] numsb=new int[3];
        for (int i = 0; i < numsb.length; i++) {
            numsb[i]=scan.nextInt();
        }
        List<List<Integer>> input=new ArrayList<>();
        List<Integer> first=new ArrayList<>();
        first.add(1);
        first.add(5);
        input.add(first);
        List<Integer> second=new ArrayList<>();
        second.add(0);
        second.add(0);
        second.add(1);
        input.add(second);
        List<Integer> third=new ArrayList<>();
        third.add(1);
        third.add(5);
        input.add(third);
        List<Integer> solution=sol(nums, numsb, input);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : solution) {
            System.out.println(integer);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> sol(int[] a,int[] b,List<List<Integer>>queries){
        List<Integer> solution=new ArrayList<>();
        Map<Integer,Integer> hMapa=new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hMapa.put(a[i],hMapa.getOrDefault(a[i], 0)+1);
        }
        Map<Integer,Integer> hMapb=new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            hMapb.put(b[i],hMapb.getOrDefault(b[i], 0)+1);
        }
        for (int i = 0; i < queries.size(); i++) {
            if(queries.get(i).size()==3){
                int[] input=new int[3];
                int k=0;
                for (int j : queries.get(i)) {
                    input[k++]=j;
                }
                int second=input[1];
                int third=input[2];
                int valueInMap=hMapa.get(a[second]);
                valueInMap=valueInMap-1;
                if(valueInMap==0){
                    hMapa.remove(a[second]);
                }else{
                    hMapa.put(a[second],valueInMap);
                }
                hMapa.put(third,hMapa.getOrDefault(third, 0)+1);

            }else{
                int[] input=new int[2];
                int k=0;
                for (int j : queries.get(i)) {
                    input[k++]=j;
                }
                int second=input[1];
                int finalAnswer=0;
                for (Map.Entry<Integer,Integer> hEntry : hMapa.entrySet()) {
                    int key=hEntry.getKey();
                    int value=hEntry.getValue();
                    int findvalue=second-key;
                    int getMapbValue=0;
                    if(hMapb.containsKey(findvalue)){
                        getMapbValue=hMapb.get(findvalue);
                    }
                        finalAnswer+=getMapbValue*value;
                }
                    if(finalAnswer!=0){
                        solution.add(finalAnswer);
                    }
                }
            }
        return solution;
    }
}  
