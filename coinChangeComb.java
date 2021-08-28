import java.util.*;
public class coinChangeComb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        int[]coins = new int[n];

        System.out.println("Enter the coins: ");
        for(int i = 0; i < coins.length;i++){
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter the sum to pay: ");
        int amnt = sc.nextInt();

        int res = ways(coins, amnt);
        System.out.println("Total ways to pay the sum of "+ amnt+" is "+ res);
    }

    public static int ways( int[] coins, int amnt ) {
        int[]dp = new int[amnt+1];

        // base case
        dp[0] = 1;

        // traversing through each coins
        for(int c=0; c<coins.length; c++) {
            // traversing from current value of coin to final amount
            for(int a=coins[c]; a<dp.length; a++) {
                dp[a] += dp[a - coins[c]];
            } 
        }

    return dp[amnt];
    }
}
