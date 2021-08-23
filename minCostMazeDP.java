import java.util.*;

public class minCostMazeDP {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] cost = new int [n][m];
        
        System.out.println("Enter cost for each cell: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        
        // for memoization
        int[][]qb = new int [n][m];
        // System.out.println(minCost(0,0,cost));
        System.out.println("Min cost paths using memoization: " + minCost_mem(0,0,cost,qb));
        System.out.println("Min cost paths using tabulation: " + minCost_tab(cost));
    }
    
    
    // tabulation
    public static int minCost_tab(int[][] cost){
        int n = cost.length;
        int m = cost[0].length;
        
        int[][]dp = new int[n][m];
        
        // dp[i][j] -> i-j to n-1,m-1 min cost
        
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                
                //no nbr => dest
                if(i == n-1 && j == m-1){
                    dp[i][j] = cost[i][j];
                }
                //no vertical nbr => last row - dest
                else if(i == n-1){
                    dp[i][j] = dp[i][j+1] + cost[i][j];
                }
                // no horizontal nbr => last col
                else if(j == m-1){
                    dp[i][j] = dp[i+1][j] + cost[i][j];
                }
                // rest
                else{
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + cost[i][j];
                }
            }
        }
        
        return dp[0][0];
    }
    
    // memoization
    public static int minCost_mem (int sr, int sc, int[][]cost, int[][] qb){
        
        // base case
        if(sr == cost.length-1 && sc == cost[0].length-1){
            return cost[sr][sc];
        }
        
        // -ve base case => should return infinity
        if(sr >= cost.length || sc >= cost[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(qb[sr][sc] != 0){
            return qb[sr][sc];
        }
        
        // horizontal neighbour
        int hntodmc = minCost_mem(sr,sc+1,cost,qb);
        
        // vertical neighbour
        int vntodmc = minCost_mem(sr+1,sc,cost,qb);
        
        // source => finds min and ads src cost
        int stodmc = Math.min(hntodmc,vntodmc) + cost[sr][sc];
        qb[sr][sc] = stodmc;
        
        return stodmc;
    }
    
    

}