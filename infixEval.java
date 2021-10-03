import java.util.*;
public class infixEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression : ");
        String exp = sc.nextLine();

        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for(int i = 0; i <exp.length(); i++) {

            char ch = exp.charAt(i);//getting each char in given expression
            
            if(ch == '(' ){
                optors.push(ch); //insert ( in opnds stack
            }
            // inserts the digit in opnds stack
            else if (Character.isDigit(ch)){
                opnds.push(ch - '0'); //as the string gives number in char too we need to change it to number 
            }

            // starts poping => carrying out operation
            else if( ch == ')' ){
                // keeps poping till we get (
                while(optors.peek() != '('){
                    char optor = optors.pop(); //pops the operator
                    int v2 = opnds.pop(); //pops the numbers => first is stored in v2 to deal with commutative prop
                    int v1 = opnds.pop();

                    int opv = operation(v1,v2,optor); //finding the value after executing the operation
                    opnds.push(opv); //inserting the value in opnds stack
                }

                optors.pop(); //to pop the ) 
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                // ch is waiting to deal with all the operators having preedence higher than itself
                // keep poping till
                // 1. all operators are finished
                // 2.we get a (
                // 3.precedence of the current operator is less than that of the one at top
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())){
                    char optor = optors.pop(); //pops the operator
                    int v2 = opnds.pop(); //pops the numbers => first is stored in v2 to deal with commutative prop
                    int v1 = opnds.pop();

                    int opv = operation(v1,v2,optor); //finding the value after executing the operation
                    opnds.push(opv); //inserting the value in opnds stack
                }
                optors.push(ch); //insert the current operator
            }
        }
        // if there was no ) none of the char starts to pop => 
        // thus to enssure all the opnds and opts are executed we run this loop
        while(optors.size() != 0){
            char optor = optors.pop(); //pops the operator
            int v2 = opnds.pop(); //pops the numbers => first is stored in v2 to deal with commutative prop
            int v1 = opnds.pop();

            int opv = operation(v1,v2,optor); //finding the value after executing the operation
            opnds.push(opv); //inserting the value in opnds stack
        }
        display(opnds.peek());
    }

    // function to set precedence for operators
    public static int precedence(char optor) {
        
        switch (optor) {
            case '+': return 1; //seting prec as 1 for +

            case '-': return 1;//seting prec as 1 for -

            case '*': return 2;//seting prec as 2 for *
        
            default:
                return 2; //seting prec as 2 for left case = /
        }
    }

    // function to carry out given operation between given v1 & v2
    public static int operation(int v1, int v2, char optor) {
        switch (optor) {
            case '+': return (v1 + v2); //adding 2 numbers

            case '-': return (v1 - v2);//subtracting 2 numbers

            case '*': return (v1 * v2);//multiplying 2 numbers
        
            default:
                return (v1 / v2); //dividing 2 numbers
        }
    }

    // function to print the result
    public static void display( int res){
        System.out.println("Result of the given expression: " + res);
    }
}
