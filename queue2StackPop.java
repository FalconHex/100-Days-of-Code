import java.io.*;
import java.util.*;

public class queue2StackPop {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

        
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter your choice: \n 1)push \n 2)pop \n 3)top \n 4)size");
        System.out.print("==> ");
        String str = br.readLine();
        System.out.println("---------------------------------------------------------------------");
        
        while (str.equals("quit") == false) {
        
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } 
            else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } 
            else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
        
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter your choice: \n 1)push \n 2)pop \n 3)top \n 4)size");
            System.out.print("==> ");
            str = br.readLine();
            System.out.println("---------------------------------------------------------------------");
        }
    }
    
    
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        // const => making empty queues
        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {      
            return mainQ.size();
        }

        void push(int val) {
        
            // removing all elem from main Q annd storing in helper q
            while(mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }

            // adding the new elem
            mainQ.add(val);

            while(helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        int pop() {
            
            if(size() == 0){
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                return mainQ.remove();
            }
        }

        int top() {
            
            if(size() == 0){
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                return mainQ.peek();
            }
        }
    }

    
}