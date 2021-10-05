import java.util.*;
public class postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a postfix expression : ");
        String exp = sc.nextLine();

        Stack<Integer> value = new Stack<>(); //stack to store value after proccessing postfix expression
        Stack<String> infix = new Stack<>(); //stack to store converted infix expression
        Stack<String> prefix = new Stack<>(); //stack to store converted prefix expression
        
        for(int i = 0; i<exp.length(); i++) {

            char ch = exp.charAt(i);//getting each char from exp
            // if it is an opr
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                // calculating value of given postfix exp
                int val2 = value.pop();
                int val1 = value.pop();
                int res = operation(val1, val2, ch);
                value.push(res);

                // converting to infix expression
                String infixVal2 = infix.pop();
                String infixVal1 = infix.pop();
                String infixRes = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixRes);

                // converting to prefix expression
                String prefixVal2 = prefix.pop();
                String prefixVal1 = prefix.pop();
                String prefixRes = ch + prefixVal1 + prefixVal2;
                prefix.push(prefixRes); 
            }
            else{
                value.push(ch - '0'); //converting the value to int type and pushing
                infix.push(ch + ""); //converting the value to string and pushing in infix stack
                prefix.push(ch + ""); //converting the value to string and pushing in prefix stack
            }
        }

        System.out.println("Value of given postfix expression => " + value.pop());
        System.out.println("Converted infix expression => " + infix.pop());
        System.out.println("Converted prefix expression => " + prefix.pop());


    }

    public static int operation(int v1, int v2, char op) {

        switch (op) {
            case '+': return v1 + v2;
            case '-': return v1 - v2;
            case '*': return v1 * v2;      
            default: return v1 / v2; //treating default as / func
        }
    }
}
