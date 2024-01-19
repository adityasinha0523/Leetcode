package Notes;
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
public class templatePriorityQueue {
    public static void main(String[] args) {
       // https://www.geeksforgeeks.org/max-heap-in-java//*
        /* 
        1.To add integer in decreasing order.
        */
        PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(Collections.reverseOrder());
        //or
        PriorityQueue<Integer> pQueue2= new PriorityQueue<Integer>(Comparator.reverseOrder());
        /*
         * 2.To add integer in ascending order.
         */
        PriorityQueue<Integer> pQueue1= new PriorityQueue<Integer>();

        /*
         * 3.To compare in a array and returning value in ascending value.and 
         * if 2nd value are equal then returning smaller of a[0].
         */
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
    }    
}
