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

class Praveenaa1{
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
        String[][] inp=new String[3][4];
        inp[0][0]="CREATE_COURSE";
        inp[0][1]="CSE220";
        inp[0][2]="Program 1";
        inp[0][3]="3";
        
        inp[1][0]="CREATE_COURSE";
        inp[1][1]="CSE220";
        inp[1][2]="Program 1";
        inp[1][3]="3";

        inp[0][0]="CREATE_COURSE";
        inp[0][1]="CSE220";
        inp[0][2]="Program 1";
        inp[0][3]="3";
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] solution(String[][] queries){
        String[] sol=new String[queries.length];
        int k=0;
        Set<String> createSetName=new HashSet<>();
        Set<Integer> createSetNum=new HashSet<>();
        Map<String,Integer> totalCredit=new HashMap<>();
        Map<String,List<String>> allCourse=new HashMap<>();
        Map<String,Integer> courseCredit=new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            String[] input=queries[i];
            if(input[0].equals("CREATE_COURSE")){
                String courseID=input[1];
                String courseNo=courseID.substring(3);
                String courseName=input[2];
                String credit=input[3];
                int creditVal=Integer.parseInt(credit);
                courseCredit.put(courseName, creditVal);
                int courseN=Integer.parseInt(courseNo);
                if(createSetNum.contains(courseN)){
                    sol[k++]="false";
                    break;
                }
                
                else if(createSetName.contains(courseName)){
                    sol[k++]="false";
                    break;
                }else{
                    sol[k++]="true";
                    createSetName.add(courseName);
                    createSetNum.add(courseN);
                }
                
            }
            else if(input[0].equals("REGISTER_FOR_COURSE")){
                String studentName=input[1];
                String course=input[2];
                if(totalCredit.containsKey(studentName)){
                    int num=totalCredit.get(studentName);
                    if(num>23){
                        sol[k++]="false";
                        continue;
                    }
                    List<String> listCourse=allCourse.get(studentName);
                    boolean foundCourse=false;
                    for (String string : listCourse) {
                        if(string.equals(course)){
                            sol[k++]="false";
                            foundCourse=true;
                            break;
                        }
                    }
                    if(foundCourse==false){
                        listCourse.add(course);
                        allCourse.put(studentName,listCourse);
                    }
                }
                List<String> list=new ArrayList<>();
                list.add(course);
                allCourse.put(studentName,list);
                totalCredit.put(studentName,totalCredit.getOrDefault(studentName, 0)+courseCredit.get(course));
                sol[k++]="true";
            }
        }
        return sol;
    }
}  