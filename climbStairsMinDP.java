import java.util.*;

public class climbStairsMinDP {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter allowed moves:");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            
        }
        
        
        System.out.println("Minimum moves found using tabulation: "+ csvj_mm_tab(arr));
        
    }
    
    
    
    public static int csvj_mm_tab(int[]jumps){
        int n = jumps.length;
        int[] dp = new int[n+1];
        
        // dp[i] => min moves from i to dest
        dp[n] = 0;
        
        for(int i= n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            
            for(int k=1; k<=jumps[i] && i+k <= n; k++){
                int nbr = i+k;
                int mmntod = dp[nbr]; //mm moves from nbr
                
                if(mmntod < min){
                    min = mmntod;
                }
            }
            
            if(min == Integer.MAX_VALUE){
                dp[i] = Integer.MAX_VALUE;
            }
            else{
                dp[i] = min+1;
            }
        }
        
        return dp[0];
    }

}