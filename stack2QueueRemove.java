import java.io.*;
import java.util.*;

public class stack2QueueRemove {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter st = new StackToQueueAdapter();

        
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter your choice: \n 1)add \n 2)remove \n 3)peek \n 4)size");
        System.out.print("==> ");
        String str = br.readLine();
        System.out.println("---------------------------------------------------------------------");
        
        while (str.equals("quit") == false) {
        
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.add(val);
            } 
            else if (str.startsWith("remove")) {
                int val = st.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } 
            else if (str.startsWith("peek")) {
                int val = st.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
        
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter your choice: \n 1)add \n 2)remove \n 3)peek \n 4)size");
            System.out.print("==> ");
            str = br.readLine();
            System.out.println("---------------------------------------------------------------------");
        }
    }
    
    
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        // const => making empty queues
        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {           
            return mainS.size();
        }

        void add(int val) {
        
            while(mainS.size() > 0) {
                helperS.add(mainS.pop());
            }

            mainS.add(val);

            while(helperS.size() > 0) {
                mainS.add(helperS.pop());
            }
        }

        int remove() {
            
            if(size() == 0){
                System.out.println("Queue underflow!");
                return -1;
            }
            else{
                return mainS.pop();
            }

        }

        int peek() {
            
            if(size() == 0){
                System.out.println("Queue underflow!");
                return -1;
            }
            else{
                return mainS.peek();
            }
            
        }
    }

    
}