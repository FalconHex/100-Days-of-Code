import java.util.*;

public class coinChangePerm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();

        int[] coins = new int[n];

        System.out.println("Enter the coins: ");
        for(int i = 0; i < coins.length; i++){
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter the amount to be paid: ");
        int amnt = sc.nextInt();

        int res = ways(coins, amnt);
        System.out.println("There are "+ res+" ways to pay the amount of "+ amnt + " using given coins!");
    }

    public static int ways(int[] coins, int amnt){
        // creating a storage to store number of ways
        // to pay  amount = index
        int[] dp = new int[amnt + 1];

        dp[0] = 1; //base problem: ways to pay 0 = 1 => don't pay

        // traverse through all index of dp
        for(int paid=1; paid <= amnt; paid++){
            // loop to use each of the given coin
            for(int coin : coins){
                // use the coin only if it's less than amnnt to be paid
                if(coin <= paid){
                    // finds remaining amount to be paid 
                    int rem = paid - coin;
                    // stores ways to pay remaining amount
                    dp[paid] += dp[rem];
                }
            }
        }
        return dp[amnt];
    }
}