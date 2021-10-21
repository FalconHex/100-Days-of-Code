import java.io.*;
import java.util.*;

public class linkedListAddLast {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        System.out.println("Keep adding nodes to list by typing 'addLast x'");
        System.out.println("To print information about list type 'display'");
        System.out.println("----------------------------------------------------");
        String str = br.readLine();
        while(str.equals("display") == false){
            if(str.startsWith("addLast")){
                // getting data to be added at last
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } 
            str = br.readLine();
        }

        dispList(list);
    }
    
    
    // defining class for node
    // stores data and adddress of next node
    public static class Node {
        int data;
        Node next;
    }

    // defining class for LL
    // has head to point first node
    // has tail to pint last node
    // has size to store size of full list
    // has func to add new nodes at last
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            
            Node temp = new Node(); //creating a new node
            temp.data = val; //storing the data 
            temp.next = null; //it's next points to null as no data after this node

            // if it is the first node
            if(size == 0) {
                head = tail = temp; //head & tails points to only node present -> temo
            }
            else{
                tail.next  = temp; //previous node's next point to current node
                tail = temp; //updating the tail node as now current node is the last
            }

            size++; //increasing the size by 1
        }
    }

    public static void dispList(LinkedList list) {
        // start a loop from node pointed by head till temp = null (last node)
        System.out.println("Data in the list : ");
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println("Size of list  = " + list.size);

        if (list.size > 0) {
            System.out.println("last node's data : " + list.tail.data);
        } 
    }
    
}