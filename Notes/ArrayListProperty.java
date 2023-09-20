//package Notes;

import java.util.*;

public class ArrayListProperty {
    
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(15);
        list.add(25);
        //Creating new List with above variables.
        List<Integer> list1=new ArrayList<>(list);
        //Above initialization will create list1 with list values.
        //To sort list1 values in ascending values.
        Collections.sort(list1);
        //To compare if both list equal or not.
        list1.equals(list);
        //To rotate all value of list by 1 index.Last value goes to 1st index.
        Collections.rotate(list, 1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
