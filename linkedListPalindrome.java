import java.io.*;
import java.util.*;

public class linkedListPalindrome {
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
        boolean res =  l1.isPalindrome();

        if(res){
            System.out.println("Given LinkedList is a palindrome!");
        }
        else{
            System.out.println("Given LinkedList is not a palindrome!");
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

        Node pleft; //left pointer that remains in heap 
        public boolean isPalindrome(){
            pleft = head; //setting left pointer at head
            return isPalindromeHelper(head); //calling helper func with arg = right pointer at head
        }

        private boolean isPalindromeHelper(Node right) {
            // base case
            if(right == null) {
                return true;
            }

            boolean recRes = isPalindromeHelper(right.next); // calling helper func recursively with arg = next to right

            // if a single comparision gives false => return false
            if(recRes == false){
                return false;
            }
            // if data at left and right pointer are not samee then return false
            else if(right.data != pleft.data){
                return false;
            }
            else{
                pleft = pleft.next; //move left pointer one ahead
                return true;
            }
        }
    }
}
