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


        /*
         * 2.LinkedList ArrayList give option to add value from front or back.
         * We can get value from first using getFirst() function.
         * We can also remove value from first using removeFirst() function.
         */
        LinkedList<Integer> linkList=new LinkedList<>();
        linkList.addFirst(10);
        linkList.addFirst(20);

        linkList.addFirst(30);
        linkList.addFirst(40);
        linkList.addLast(60);
        linkList.addLast(70);
        linkList.addLast(80);
        linkList.addLast(90);
        System.out.println("Linked List Start");
        for (Integer integer : linkList) {
            System.out.println(integer);
        }
        System.out.println("Linked List End");
        System.out.println(linkList.getFirst());
        System.out.println(linkList.getLast());
        System.out.println(linkList.removeFirst());
        System.out.println(linkList.removeLast());
    }
}
