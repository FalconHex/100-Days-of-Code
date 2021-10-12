import java.util.*;

public class minStack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter the function for stack: \n 1}push \n 2}pop \n 3}top \n 4}size \n 5}min \n or type 'quit' to end: ");
        String str = sc.nextLine();

        // object of our class which acts as stack
        MINSTACK st = new MINSTACK();

        // taking action to be done on stack
        while(str.equals("quit") == false){
            
            switch (str) {
                // inserts in the given element to stack
                case "push":{
                    System.out.print("Enter value to be pushed: ");
                    int val = Integer.parseInt(sc.nextLine());
                    st.push(val);
                    break;
                }

                // removes the element present on top
                case "pop":{
                    System.out.println("---------------------------------------------------------------------");
                    int val = st.pop();
                    if(val != -1){
                        System.out.println("element popped : " + val);
                    }
                    break;
                }

                // displays the element on top
                case "top":{
                    System.out.println("---------------------------------------------------------------------");
                    int val = st.top();
                    if(val != -1){
                        System.out.println("top element: " + val);
                    }
                    break;
                }

                // gives number of elements
                case "size":{
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Size of stack: " + st.size());
                    break;
                }

                // prints min elements 
                case "min":{
                    System.out.println("---------------------------------------------------------------------");
                    int val = st.min();
                    if(val != -1){
                        System.out.println("Min element: " + val);
                    }
                    break;
                }

                
            
                default:{
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Not valid input");
                    break;
                }
                    
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Enter the function for stack: \n 1}push \n 2}pop \n 3}top \n 4}size \n 5}min \n or type 'quit' to end: ");
            str = sc.nextLine();
        }
    }
    

    // own class acting as stack
    public static class MINSTACK {
        Stack<Integer> allData = new Stack<>();
        Stack<Integer> minData = new Stack<>();
        // constructor
        public MINSTACK() {
            allData = new Stack<>();
            minData = new Stack<>();
        }
        // fun to push => add element to stack
        void push(int val) {

            allData.push(val); //pushing element to all data stack

            if(minData.size() == 0 || val <= minData.peek()) {
                minData.push(val); //pushing val to mindata stack if it is less than top of min stack
            }
        }

        // fun to pop => remove the top element
        int pop() {
            if(allData.size() == 0){
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                int elem = allData.pop();
                // if the elem popped from all data is = that of mindata pop from min data too
                if(elem == minData.peek()){
                    minData.pop();
                }
                return elem;

            }
        }

        // fun to display top => print the top most element
        int top() {
            if(allData.size() == 0){
                System.out.println("Stack Underflow!");
                return -1; //flag for error
            }
            else{
                return allData.peek();
            }
        }
        
        // fun to display size of stack 
        int size() {
            return allData.size(); //tells size of stack
        }
        
        // fun to display min element of stack 
        int min(){
            if(allData.size() == 0){
                System.out.println("Stack Underflow!");
                return -1; //flag for error
            }
            else{
                return minData.peek();
            }
        }
    }

    
}
