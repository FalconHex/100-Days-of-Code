import java.util.*;
public class stocksInfTA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[]prices = new int[n];

        System.out.println("Enter prices for :");
        for(int i = 0; i < prices.length; i++) {
            System.out.print("Day "+i+" : ");
            prices[i] = sc.nextInt();
        }

        // setting buy date and sell date as 0 intially
        int bd = 0;
        int sd = 0;
        int profit = 0;

        // starting from day 2 
        for(int i=1; i < prices.length; i++) {
            // if price is more the rev day=> don't sell
            if(prices[i] >= prices[i-1] ){
                sd++;
            }
            else{
                profit += prices[sd] - prices[bd];
                // setting buy and sell date to current date
                bd = sd = i;
            }
        }
        // selling for the last date
        profit += prices[sd] - prices[bd];
        System.out.println("Profit = "+ profit);
    }
}
