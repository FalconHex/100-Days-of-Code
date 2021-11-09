import java.io.*;
import java.util.*;

public class linkedListAdd {
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

        System.out.println("Given LinkedLists: ");
        System.out.print("=> "); 
        l1.display();
        System.out.print("=> ");
        l2.display();
        
        LinkedList sum = LinkedList.addLL(l1, l2);
        System.out.println("Addition of LinkedLists: ");
        sum.display();
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

        public void addFirst(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head  = temp;

            if(size == 0){
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

        public static LinkedList addLL(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            // old carry
            int oc = addLLHelper(one.head, one.size, two.head, two.size, res);

            if(oc > 0){
                res.addFirst(oc);
            }

            return res;
        }

        private static int addLLHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            // base case
            if(one == null && two == null) {
                return 0; // 0 = carry
            }

            int sum = 0;
            
            if(pv1 > pv2) {
                int oc = addLLHelper(one.next, pv1-1, two, pv2, res);
                sum = one.data + oc;
            }
            else if(pv1 < pv2) {
                int oc = addLLHelper(one, pv1, two.next, pv2-1, res);
                sum = two.data + oc;
            }
            else{
                int oc = addLLHelper(one.next, pv1-1, two.next, pv2-1, res);
                sum = one.data + two.data + oc;
            }

            int c = sum/10;
            int d = sum%10;
            res.addFirst(d);
            return c;

        }
    }
}

