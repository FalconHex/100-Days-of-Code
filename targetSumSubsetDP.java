import java.util.*;

public class targetSumSubsetDP {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        
        System.out.println("Enter elements of array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        boolean ans = targetSumSubset(arr,target);
        
        System.out.println(ans);

        if(ans){
            System.out.print("Target of "+target+" can be achieved from the given array!");
        }
        else{
            System.out.print("Target of "+target+" can't be achieved from the given array!");
        }
    }
    
    public static boolean targetSumSubset(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length][target+1];
        // dp[i][j] = if subset till i can give sum = j
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j == 0){
                    // target 0 
                    dp[i][j] = true;
                }
                else if(i == 0){
                    if(arr[i] <= target){
                        // col == value of elem => single elem 0th row
                        dp[i][arr[i]] = true;
                    }
                }
                else{
                    boolean exc = dp[i-1][j];
                    boolean inc = false;
                    // if elem going to be included is 
                    // smaller than target - sum till now
                    if(j-arr[i] >= 0){
                        // if i'm included then check if 
                        // diff of col and elem is achivable
                        inc = dp[i-1][j-arr[i]];
                    }
                    // if anyone is true place true
                    dp[i][j] = inc || exc;
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}