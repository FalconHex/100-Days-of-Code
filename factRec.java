import java.util.*;

public class factRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = factRec(n);
        System.out.println(res);
    }
    
    public static int factRec(int n) {

        // base case: 0! = 1
        if(n==0){
            return 1;
        }
        // faith: gives factorial of n-1
        int fnm1 = factRec(n-1);
        // my work
        int res = n*fnm1;
        return res;
    }
}
