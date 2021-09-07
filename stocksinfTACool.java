import java.util.*;
public class stocksinfTACool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        
        int[] prices = new int[n];

        System.out.println("Enter price for:");
        for(int i = 0; i < prices.length; i++) {
            System.out.print("Day "+ i+1 +" : ");
            prices[i] = sc.nextInt();
        }

        int profit = findMax(prices);
        System.out.println("Max profit = "+ profit);
    }
    public static int findMax(int[] prices) {
        int n = prices.length;
        int obsp = -prices[0]; // old buy state profit
        int ossp = 0;// old sell state profit 
        int ocsp = 0; //old cool state profit
        
        for(int i=1; i< prices.length; i++){
            int nbsp = 0; //new buy state profit
            int nssp = 0; //new sell state profit
            int ncsp = 0; //new cool state profit

            // finding nbsp =>  build on oscp
            if(ocsp - prices[i] > obsp){
                nbsp = ocsp - prices[i];
            }
            else{
                nbsp = obsp;
            }

            // finding nssp => build on obsp
            if(obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            }
            else{
                nssp = ossp;
            }

            // findin ncsp => direct comp to ossp
            if(ossp  > ocsp) {
                ncsp = ossp;
            }
            else{
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }
}
