import java.io.*;
import java.util.*;

public class merge2LinkedList {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size of LinkedList 1: ");
        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        
        System.out.println("Enter all the elements seperated with a space:");
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        System.out.print("Enter size of LinkedList 2: ");
        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();

        System.out.println("Enter all the elements seperated with a space:");
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int d = Integer.parseInt(values2[i]);
            l2.addLast(d);
        }

        LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
        
        System.out.println("Linked List 1 : ");
        l1.display();
        System.out.println("Linked List 2 : ");
        l2.display();
        System.out.println("Linked Lists after merging : ");
        merged.display();
        
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

        public static LinkedList mergeTwoSortedLists (LinkedList l1, LinkedList l2) {
            Node one = l1.head; //pointer for 1st LL
            Node two = l2.head; //pointer for 2nd LL

            LinkedList result = new LinkedList();

            while(one != null && two != null) {
                
                if(one.data < two.data){
                    result.addLast(one.data); //add one's data to res
                    one = one.next; //increment one's pointer
                }
                else{
                    result.addLast(two.data); //add two's data to res
                    two = two.next; //increment two's pointer
                }
            }

            while(one != null){
                result.addLast(one.data); //add one's data to res
                one = one.next; //increment one's pointer
            }
            while(two != null){
                result.addLast(two.data); //add two's data to res
                two = two.next; //increment two's pointer
            }

            return result;
        }

    }

    
}