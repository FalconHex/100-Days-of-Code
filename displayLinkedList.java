import java.io.*;
import java.util.*;

public class displayLinkedList {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedList list = new LinkedList();
    
        System.out.println("Keep adding nodes to list by typing 'addLast x'");
        System.out.println("To print information about list type 'display'");
        System.out.println("----------------------------------------------------");
        String str = br.readLine();
        addLast 10
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } 
            else if (str.startsWith("size")) {
                System.out.println(list.size());
            } 
            else if (str.startsWith("display")) {
                list.display();
            }
            str = br.readLine();
        }
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } 
            else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + "|");
            }
            System.out.println();
        }
    }

  
}