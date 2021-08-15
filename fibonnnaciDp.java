import java.util.*;

public class fibonnnaciDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        // making question bank for memoization => intially filled with 0
        // int[]qb = new int[n+1];

        // int res_mem = fib_mem(n, qb);
        // System.out.println(n+"th "+ "Fibonacci found using memoization = "+ res_mem);

        int res_tab = fib_tab(n);
        System.out.println(n+"th "+"Fibonacci found using tabulation = "+ res_tab);
    }

    public static int fib_mem(int n, int[]qb){
        // base case
        if(n==0 || n== 1){
            return n;
        }

        // checking if answer exsists
        if(qb[n] != 0){
            return qb[n];
        }

        int fibN = fib_mem(n-1, qb) + fib_mem(n-2, qb);
        qb[n] = fibN;

        return fibN;
    }

    public static int fib_tab(int n){

        // an array to stimulate recursion result
        int[] dp = new int[n+1];

        // solving min problems
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
