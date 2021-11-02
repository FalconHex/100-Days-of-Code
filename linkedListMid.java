import java.io.*;
import java.util.*;

public class linkedListMid {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedList list = new LinkedList();
    
        System.out.println("Keep adding nodes to list by typing 'addLast x'");
        System.out.println("To print information about list type 'display'");
        System.out.println("To remove first element type 'removeFirst'");
        System.out.println("To get a value at first type 'getFirst");
        System.out.println("To get a value at last type 'getLast");
        System.out.println("To get a value at index type 'getAt x");
        System.out.println("To add element at first type 'addFirst x");
        System.out.println("To add element at first type 'addAt idx x");
        System.out.println("To remove last element type 'removeLast");
        System.out.println("To remove element at any index type 'removeAt idx");
        System.out.println("To reverse the linked list type 'reverseDI");
        System.out.println("To reverse the linked list type 'reversePI");
        System.out.println("To get Kth node in linked list type 'kthFromEnd k'");
        System.out.println("To get mid node in linked list type 'mid'");


        System.out.println("----------------------------------------------------");
        String str = br.readLine();
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
            else if(str.startsWith("removeFirst")){
                list.removeFirst();
            }
            else if(str.startsWith("getFirst")){
                int val = list.getFirst();
                if(val != -1){
                    System.out.println("First value in list = "+val);
                }
                
            }
            else if(str.startsWith("getLast")){
                int val = list.getLast();
                if(val != -1){
                    System.out.println("Last value in list = "+val);
                }
                
            }
            else if(str.startsWith("getAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if(val != -1){
                    System.out.println("Value at index " + idx + " = " + val);
                }
            }
            else if(str.startsWith("addFirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            }

            else if(str.startsWith("addAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            }

            else if(str.startsWith("removeLast")){
                list.removeLast();
            }
            else if(str.startsWith("removeAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }
            else if (str.startsWith("reverseDI")) {
                list.reverseDI();
            }
            else if(str.startsWith("reversePI")){
                list.reversePI();
            }
            else if (str.startsWith("kthFromEnd")) {
                
                int idx = Integer.parseInt(str.split(" ")[1]);
                System.out.println(list.kthFromEnd(idx));
            }
            else if (str.startsWith("mid")) {
                
                int val = list.mid();
                System.out.println("Element at mid of LinkedList = " + val);
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

        public int getLast(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }
            else{
                return tail.data;
            }
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }
            else if(idx < 0 || idx >= size){
                System.out.println("Invalid Input");
                return -1;
            }
            else{
                Node temp = head;
                for(int i = 0; i < idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
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

        public void addAt(int idx, int val){
            
            if(idx < 0 || idx > size){
                System.out.println("Invalid index");
            }
            else if(idx == 0){
                addFirst(val);
            }
            else if(idx == size){
                addLast(val);
            }
            else{
                Node node = new Node();
                node.data = val;
                Node temp = head;
                
                for(int i = 0; i < idx -1; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
            
            
        }

        public void removeLast(){
            if(size == 0){
                System.out.println("List is empty");
            }
            else if (size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                Node temp = head;
                for(int i=0; i < size-2 ; i++){
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if(idx < 0 || idx > size){
                System.out.println("Invalid index");
            }
            else if(idx == 0){
                removeFirst();;
            }
            else if(idx == size - 1){
                removeLast();;
            }
            else{
                Node temp = head;
                for(int i = 0; i < idx-1; i++){
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx){
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            int li  = 0;
            int ri = size - 1;

            while(li <ri){
                Node left  = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI() {
            Node prev = null;
            Node curr = head; 

            while(curr != null) {
                Node next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromEnd(int k) {
            Node slow = head; //slow pointer 
            Node fast = head; //fast pointer
    
            // making a gap b/w pointers = k (index)
            for(int i = 0; i < k; i++) {
                fast = fast.next;
            }
    
            // when fast reaches tail slow is at right position
            while(fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
    
            return slow.data;
        }

        public int mid(){
            Node slow = head; //slow pointer => moves by 1 step
            Node fast = head; //fast pointer => moves by 2 step

            // when either fast pointer's next is null or next to next is null => stop
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next; //incrementing by 1
                fast = fast.next.next; //incrementing by 2
            }

            return slow.data;
        }
    }
    
    
}