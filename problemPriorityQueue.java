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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;
public class problemPriorityQueue {
    /*
     * 1.Adding 2D array in pq with 2 value in descending.
     */
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]);
    //queue.addAll(Arrays.asList(boxTypes));

}
