import java.util.*;

public class decToAny {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number to be converted
        int n = sc.nextInt();
        // base in which n is to be coverted
        int b = sc.nextInt();
        
        int res = decToAnyBase(n, b);
        System.out.println(res);
    }

    public static int decToAnyBase(int n, int b) {

        // a var to store result
        int res = 0;
        //  a power var to position the res digit one by one
        int pw = 1;

        while(n>0){

            
            // getting base equivalent of dig 
            // divide by dest. base
            int dig = n%b;
            // removing treated dig from num
            n = n/b;

            // positioning it in the right place
            res += dig*pw;
            
            // multiply pw with exsisting base
            pw = pw*10;
        }

        return res;
    }
}
