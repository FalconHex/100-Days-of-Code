import java.io.*;
import java.util.*;

public class linkedListMergeSort {
    
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

        

        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        
        System.out.println("Given LinkedList : ");
        l1.display();
        System.out.println("Sorted LinkedList : ");
        sorted.display();
        
        
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

        public static Node midNode(Node head, Node tail){
            Node fast = head;
            Node slow = head;

            while(fast != tail && fast.next != tail){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }
        
        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }

            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);

            LinkedList res = mergeTwoSortedLists(fsh, ssh);
            return res;
        }

        

    }

    
}