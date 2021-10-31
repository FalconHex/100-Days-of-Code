import java.io.*;
import java.util.*;

public class linkedListToQueue {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToQueueAdapter st = new LLToQueueAdapter();

        System.out.println("Enter any option : ");
        System.out.println("1.add x \n2.remove \n3.peek \n4.size \n5.quit");
    
        String str = br.readLine();
        while(str.equals("quit") == false){
            
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.add(val);
            } 
            else if(str.startsWith("remove")){
                int val = st.remove();
                if(val != -1){
                    System.out.println("Value removed = " + val);
                }
            } 
            else if(str.startsWith("peek")){
                int val = st.top();
                if(val != -1){
                    System.out.println("Value at start = " + val);
                }
            } 
            else if(str.startsWith("size")){
                System.out.println("Size of queue = " + st.size());
            }
            str = br.readLine();
        }
    }
    
    public static class LLToQueueAdapter {
        LinkedList<Integer> list;

        public LLToQueueAdapter() {
            list = new LinkedList<>();
        }


        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        int remove() {
            if(size() == 0) {
                System.out.println("Queue underflow!");
                return -1;
            }
            else{
                return list.removeFirst();
                
            }
        }

        int top() {
            if(size() == 0) {
                System.out.println("Queue underflow!");
                return -1;
            }
            else{
                return list.getFirst();
            }
        }
    }
}