import java.util.*;
public class stairPathsDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of steps: " );
        int n = sc.nextInt();

        // creating question bank
        // int[]qb = new int[n+1];

        // int res_mem = paths_mem(n, qb);
        // System.out.println("Number of paths found using memoization: "+ res_mem);
        int res_tab = paths_tab(n);
        System.out.println("Number of paths found using tabulation: "+ res_tab);
    }

    public static int paths_mem(int n, int[] qb) {
        // +ve base case
        if(n==0){
            return 1;
        }
        // -ve base case
        if(n < 0){
            return 0;
        }
        // checking if ans exsists
        if(qb[n] != 0){
            return qb[n];
        }
        int ways = paths_mem(n-1,qb) + paths_mem(n-2,qb) + paths_mem(n-3,qb);
        qb[n] = ways; // storing ans
        return ways;
    }

    public static int paths_tab(int n) {
        int[]dp = new int[n+1];
        // if at step 0 => jump on the spot
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1){
                // if at step 1=> one way take a jump of 1
                dp[i] = dp[i-1];
            }
            else if(i == 2){
                // if at step 2 => ways using jump of 1 + ways using jump of 2
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                // if at step 3 or more => ways of using jump of 1 + ways of using jump of 2 + ways using jump of 3 
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }
}
