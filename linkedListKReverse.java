import java.io.*;
import java.util.*;

public class linkedListKReverse {
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

        System.out.print("Enter the value for reverse: ");
        int k = Integer.parseInt(br.readLine());


        System.out.println("Given LinkedList: ");
        l1.display();
        l1.kRev(k);
        System.out.println("LinkedList after reversing: ");
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

        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            }
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                head = head.next;
                size--;
            }
        }

        public int getFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }
            else{
                return head.data;
            }
        }

        public void kRev(int k) {
            LinkedList prev = null;
            
            while(this.size > 0) {
                LinkedList curr = new LinkedList();

                if(this.size >= k){
                    for(int i=0; i<k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();

                        curr.addFirst(val);
                    }
                }
                else{
                    int sz = this.size;
                    for(int i=0; i<sz; i++) {
                        int val = this.getFirst();
                        this.removeFirst();

                        curr.addLast(val);
                    }
                }

                if(prev == null) {
                    prev = curr;
                }
                else{
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }  

    }
}
