import java.util.*;
public class minStack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter the function for stack: \n 1}push \n 2}pop \n 3}top \n 4}size \n 5}min \n or type 'quit' to end: ");
        String str = sc.nextLine();

        // object of our class for stack
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

    public static class MINSTACK {
        Stack<Integer> allData = new Stack<>();
        int min; //var to store min
        
        // constructor
        public MINSTACK() {
            allData = new Stack<>();
        }
        // fun to push => add element to stack
        void push(int val) {
            // first element
            if(size() == 0) {
                allData.push(val); //pushing element to all data stack
                min = val; //considering first element as min
            }
            else if(val >= min) {
                allData.push(val); //simply push as min is not challenged
            }
            // we get new min
            else{
                allData.push(val + (val - min)); // this will push a fake element wiz smaller than min at that level
                min = val; //updating the min
            }
            
        }

        // fun to pop => remove the top element
        int pop() {
            if(allData.size() == 0){
                System.out.println("Stack underflow!");
                return -1;
            }
            else{
                // this is the case when min was updated
                // 1.pop fake value out of stack
                // 2.get value of min which was before updating at this level
                if(allData.peek() < min ){
                    int oval = min; //this was the num given by user to store
                    min = ((2*min) - allData.pop());
                    return oval;
                }

                // normal case
                else{
                    return allData.pop(); //val is og simply pop it out
                }
            }
        }

        // fun to display top => print the top most element
        int top() {
            if(allData.size() == 0){
                System.out.println("Stack Underflow!");
                return -1; //flag for error
            }
            else{
                // this is the case when min was updated
                // thus stack has a fake value and og val is in min
                if(allData.peek() < min ){
                    return min;
                }

                else{
                    return allData.peek();
                }
                
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
                return min;
            }
        }
    }
}
