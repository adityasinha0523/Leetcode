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

class problem207{
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
        int[][] prerequisites=new int[2][2];
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[0].length; j++) {
                prerequisites[i][j]=scan.nextInt();
            }
        }
        int numCourses=scan.nextInt();
        
        boolean sol=canFinish(numCourses, prerequisites);
        
        System.out.println(sol);
        scan.close();
    }  

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> courseDict=new HashMap<>();
        
        for (int[] relation : prerequisites) {
            if(courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            }else{
                List<Integer> nextCourse=new LinkedList<>();
                nextCourse.add(relation[0]);
                courseDict.put(relation[1], nextCourse);
            }
        }

        boolean[] path=new boolean[numCourses];
        boolean[] checked=new boolean[numCourses];
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if(isCyclic(currCourse,courseDict,checked,path)){
                return false;
            }
        }

        return true;
    }

    public static boolean isCyclic(Integer currCourse,HashMap<Integer,List<Integer>> courseDict,boolean[] checked,boolean[] path){
        if(checked[currCourse]){
            return false;
        }
        if(path[currCourse]){
            return true;
        }
        if(!courseDict.containsKey(currCourse)){
            return false;
        }
        path[currCourse]=true;
        boolean ret=false;
        for (Integer nextCourse : courseDict.get(currCourse)) {
            ret=isCyclic(nextCourse, courseDict,checked, path);
            if(ret){
                break;
            }
        }
        path[currCourse]=false;
        checked[currCourse]=true;
        return ret;
    }
}  