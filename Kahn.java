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

class Kahn{
    public static void main(String[] args) {
        //System.out.println("hello");
        int v=6;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        List<Integer> result=sort4(v,adj);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static public List<Integer> sort2(int v,ArrayList<ArrayList<Integer>> adj){
    System.out.println("Topological sort 2");
    List<Integer> result=new ArrayList<>();
    int[] indegree=new int[v];
    for (int i = 0; i < v; i++) {
        for (int val : adj.get(i)) {
            indegree[val]++;
        }
    }
    Queue<Integer> queue=new LinkedList<>();
    for (int i = 0; i < indegree.length; i++) {
        if(indegree[i]==0){
            queue.add(i);
        }
    }
    while(!queue.isEmpty()){
        int node=queue.poll();
        result.add(node);
        for (int index : adj.get(node)) {
            indegree[index]--;
            if(indegree[index]==0){
                queue.add(index);
            }
        }
    }
    return result;
    }

    static public List<Integer> sort(int v,ArrayList<ArrayList<Integer>> adj){
        System.out.println("Topological sort 1");
        List<Integer> result =new ArrayList<>();
        int[] indegree=new int[v];
        for (int i = 0; i < v; i++) {
            for (int val : adj.get(i)) {
                indegree[val]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }
        if(result.size()!=v){
            System.out.println("Cycle detected");
            return new ArrayList<>();
        }
        return result;
    }



    static public List<Integer> sort3(int v,ArrayList<ArrayList<Integer>> adj){
        System.out.println("Topological sort 3");
        List<Integer> result=new ArrayList<>();
        int[] indegree=new int[v];
        for (int i = 0; i < v; i++) {
            for (int val : adj.get(i)) {
                indegree[val]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            for (int value : adj.get(node)) {
                indegree[value]--;
                if(indegree[value]==0){
                    queue.add(value);
                }
            }
        }
        return result;
    }


    static public List<Integer> sort4(int v,ArrayList<ArrayList<Integer>> adj){
        System.out.println("Topological sort 4");
        List<Integer> result=new ArrayList<>();
        int[] indegree=new int[v];
        for (int i = 0; i < v; i++) {
            for (int value : adj.get(i)) {
                indegree[value]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node =queue.poll();
            result.add(node);
            for (int index : adj.get(node)) {
                indegree[index]--;
                if(indegree[index]==0){
                    queue.add(index);
                }
            }
        }
        return result;
    }
}