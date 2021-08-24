import java.util.*;

public class goldMine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][]gold = new int[n][m];
        
        System.out.println("Enter amount of gold in each cell: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                gold[i][j] = sc.nextInt();
            }
        }
        
        
        System.out.println("Maximum gold that can be obtained = " + maxGold_tab(gold));
        
    }
    
    public static int maxGold_tab(int[][] gold){
        
        int n = gold.length;
        int m = gold[0].length;
        
        // 2d array to store prev ans
        int[][] dp = new int[n][m];
        
        // dp[i][j] = max gold from itself
        
        for(int j=m-1; j>=0; j--){
            for(int i=0; i<n; i++){
                
                // last col => no nbr
                if(j == m-1){
                    dp[i][j] = gold[i][j];
                }
                // first row => no upper nbr
                else if(i == 0){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + gold[i][j];
                }
                // last row => no lower nbr
                else if(i == n-1){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + gold[i][j];
                }
                // rest
                else{
                    dp[i][j] = Math.max(Math.max(dp[i][j+1],dp[i+1][j+1]),dp[i-1][j+1]) + gold[i][j];
                }
            }
        }
        
        int omax = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            if(dp[i][0] > omax){
                omax = dp[i][0];
            }
        }
        
        return omax;
    }
    

}