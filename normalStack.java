import java.util.*;

public class normalStack {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter the function for stack: \n 1}push \n 2}pop \n 3}top \n 4}size \n 5}display \nor type 'quit' to end: ");
        String str = sc.nextLine();

        // object of our class which acts as stack
        CustomStack st = new CustomStack(n);

        // taking action to be done on stack
        while(str.equals("quit") == false){
            
            switch (str) {
                // inserts in the given element to array
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

                // prints all the elements 
                case "display":{
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Given stack is: ");
                    st.display();
                    break;
                }
            
                default:{
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Not valid input");
                    break;
                }
                    
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Enter the function for stack: \n 1}push \n 2}pop \n 3}top \n 4}size \n 5}display \nor type 'quit' to end: ");
            str = sc.nextLine();
        }
    }
    
    // own class acting as stack
    public static class CustomStack {
        int[] data;// array acting as stack
        int tos; //top of stack

        // paramaetrized constructor
        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        // fun to push => add element to stack
        void push(int val) {
            
            // if top of stack is not at last index
            if(tos == data.length - 1){
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Stack Overflow!");
            }
            else{
                tos++; //moving top to the new element added
                data[tos] = val;
            }
        }

        // fun to pop => remove the top element
        int pop() {
            
            if(tos == -1 ){
                System.out.println("Stack Underflow!");
                return -1; //flag for error
            }
            else{
                int val = data[tos];
                tos--; //moving top to 2nd last element
                return val;
            }
        }

        // fun to display top => print the top most element
        int top() {
            if(tos == -1){
                System.out.println("Stack Underflow!");
                return -1; //flag for error
            }
            else{
                int val = data[tos];
                return val;
            }
        }
        
        // fun to display size of stack 
        int size() {
            return tos + 1; //as tos is the index of last elem
        }

        // fun to show full stack
        void display() {
            for(int i = tos; i >= 0; i--){
                System.out.print(data[i] + " | ");
            }
            System.out.println();
        }      
    }

    
}