import java.util.*;
public class prefix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a prefix expression : ");
        String exp = sc.nextLine();

        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for(int i = exp.length()-1 ; i >= 0 ; i--) {
            char ch = exp.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                // calc the value of prefix
                int val1 = value.pop();
                int val2 = value.pop();
                int res = op(val1, val2, ch);
                value.push(res);

                // conv to infix
                String infixVal1 = infix.pop();
                String infixVal2 = infix.pop();
                String infixRes = "(" + infixVal1 + ch + infixVal2 + ")";
                infix.push(infixRes);

                // conv to postfix
                String postfixVal1  = postfix.pop();
                String postfixVal2 = postfix.pop();
                String postfixRes = postfixVal1 + postfixVal2 + ch;
                postfix.push(postfixRes);
            }
            else{
                infix.push(ch + "");
                postfix.push(ch + "");
                value.push(ch - '0');
            }
        }

        System.out.println("Value of given prefix expression => " + value.pop());
        System.out.println("Converted infix expression => " + infix.pop());
        System.out.println("Converted postfix expression => " + postfix.pop());

    }

    public static int op(int v1, int v2, char op) {

        switch (op) {
            case '+': return v1 + v2;

            case '-': return v1 - v2;

            case '*': return v1 * v2;
        
            default:
                return v1 / v2;
        }
    }
}