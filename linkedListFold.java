import java.io.*;
import java.util.*;

public class linkedListFold {
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
        l1.fold();
        System.out.println("LinkedList after fold: ");
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

        Node fleft; //left pointer that remains in heap 
        
        public void fold(){
            fleft = head; //setting left pointer at head
            //calling helper func with arg = right pointer at head & floor value=0
            foldHelper(head , 0); 
        }

        private void foldHelper(Node right, int floor) {
            // base case
            if(right == null) {
                return ;
            }

            // calling helper func recursively with arg = next to right & incrementing floor
            foldHelper(right.next, floor+1); 

            // till half of linked list
            if(floor > size/2){
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;
                fleft = temp;
            }
            // at mid point of linked list
            else if(floor == size/2){
                tail = right;
                tail.next = null;
            }
        }
    }
}
