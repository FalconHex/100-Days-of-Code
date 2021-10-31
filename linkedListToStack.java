import java.io.*;
import java.util.*;

public class linkedListToStack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();

        System.out.println("Enter any option : ");
        System.out.println("1.push x \n2.pop \n3.top \n4.size \n5.quit");
    
        String str = br.readLine();
        while(str.equals("quit") == false){
            
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } 
            else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println("Value popped = " + val);
                }
            } 
            else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println("Value at top = " + val);
                }
            } 
            else if(str.startsWith("size")){
                System.out.println("Size of stack = " + st.size());
            }
            str = br.readLine();
        }
    }
    
    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if(size() == 0) {
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                int val = list.getFirst();
                list.removeFirst();
                return val;
            }
        }

        int top() {
            if(size() == 0) {
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                int val = list.getFirst();
                return val;
            }
        }
    }
}