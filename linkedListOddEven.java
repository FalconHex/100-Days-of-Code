import java.io.*;
import java.util.*;

public class linkedListOddEven {
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
        l1.oddEven();
        System.out.println("LinkedList after seprating odd and even elements: ");
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

        public void oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            
            // till nodes are left in given list
            while (this.size() > 0) {
                // get the node and remove from given list
                int val =  this.getFirst();
                this.removeFirst();
    
                if(val % 2 == 0) {
                    even.addLast(val);
                }
                else{
                    odd.addLast(val);
                }
                
            }
    
            if(odd.size() > 0 && even.size() > 0) {
                odd.tail.next = even.head;

                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }
            else if(odd.size() > 0 ){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else if(even.size() > 0 ){
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
            
        }

    }
}
