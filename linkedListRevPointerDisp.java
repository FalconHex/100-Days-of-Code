import java.io.*;
import java.util.*;

public class linkedListRevPointerDisp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size of LinkedList : ");
        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        
        System.out.println("Enter all the elements seperated with a space:");
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        System.out.println("Given LinkedList: ");
        l1.display();
        l1.dispRev();
        System.out.println("LinkedList in reverse order: ");
        l1.display();
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
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public int size() {
            return size;
        }

        public void dispRev(){
            rev(head);
            
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public void rev (Node node){
            if(node == null){
                return;
            }

            rev(node.next);
            
            if(node == tail){
                // do nothing
            }
            else{
                node.next.next = node;
            }
        }


    }
}

