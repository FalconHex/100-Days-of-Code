import java.util.*;
public class infixConv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression : ");
        String exp = sc.nextLine();

        Stack<String> post = new Stack<>(); //stack to store postfix
        Stack<String> pre = new Stack<>();//stack to store prefix
        Stack<Character> ops = new Stack<>();//stack to store operators

        for(int i=0; i<exp.length(); i++) {

            char ch = exp.charAt(i);//taking each char of expression

            // pushing chars to diffrent stacks
            if (ch == '('){
                ops.push(ch);
            }
            else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <='Z') || (ch >= '0' && ch <= '9')) {
                post.push(ch + ""); //pushing ch in post stack after coverting to string 
                pre.push(ch + ""); //pushing ch in pre stack after coverting to string 
            }
            
            else if(ch == ')'){
                // keep poping till you get (
                while(ops.peek() != '('){

                    char op = ops.pop();
                    // creating postfix exp
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postExp = postv1 + postv2 + op;
                    post.push(postExp);

                    // creating prefix exp 
                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preExp = op + prev1 + prev2;
                    pre.push(preExp);
                }
                ops.pop(); //popping the last (
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){

                // keep poping till 
                // 1.all operators are over 
                // 2.encounter (
                // 3. precedence of current operator is less than that inside
                while( ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())){

                    char op = ops.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postExp = postv1 + postv2 + op;
                    post.push(postExp);

                    
                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preExp = op + prev1 + prev2;
                    pre.push(preExp);
                }

                // after proceesing the ops push the operator
                ops.push(ch);
            }
        }

        // complete for leftover ops
        while(ops.size() > 0){

            char op = ops.pop();
            String postv2 = post.pop();
            String postv1 = post.pop();
            String postExp = postv1 + postv2 + op;
            post.push(postExp);

            
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preExp = op + prev1 + prev2;
            pre.push(preExp);
        }

        System.out.println("Postfix of given exp => " + post.pop());
        System.out.println("Prefix of given exp => " + pre.pop());

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
}
