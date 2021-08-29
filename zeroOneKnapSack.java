import java.util.*;
public class zeroOneKnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  number of elements: ");
        int n = sc.nextInt();

        int[]vals = new int[n];
        System.out.println("Enter value of each item: ");
        for(int i = 0; i<vals.length; i++){
            vals[i] = sc.nextInt();
        }

        int[]wts = new int[n];
        System.out.println("Enter weight of each items: ");
        for(int i = 0; i<wts.length; i++){
            wts[i] = sc.nextInt();
        }

        System.out.print("Ente weight capacity of sack: ");
        int cap = sc.nextInt();

        int res = maxVal(n, vals, wts, cap);
        System.out.println("Max value obtained = " + res);
    }

    public static int maxVal(int n, int[]vals, int[]wts, int cap) {
        // make a 2d storage where
        // columns: weights & rows: element with val
        int[][] dp = new int[n+1][cap+1];

        // i and j points to one index less in vals and wts
        // as 1st row and col are always 0 
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++){
                // weight of current col > weight of element
                if(j >= wts[i-1]){
                    // remaining capacity
                    int rCap = j - wts[i-1];
                    // include the item only if it's participation
                    // makes the sum value  more than it's prev elems
                    if(dp[i-1][rCap] + vals[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][rCap] + vals[i-1];
                    }
                    else{
                        //current elem does not take part
                        // as it's addition is of no use
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    // weight of current elem > weight of column
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][cap];
    }
}
