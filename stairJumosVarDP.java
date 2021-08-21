import java.util.*;

public class stairJumosVarDP {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();
        
        int[]arr = new int[n];
        System.out.println("Enter valid jumps: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        // Memoization
        int[]qb = new int[n+1];
        // filling array qb with -1
        Arrays.fill(qb,-1);

        int ways_mem = csvj_mem(0,arr,qb);
        System.out.println("Ways found using memoization = "+ ways_mem);
        
        // for tabulation
        System.out.println("Ways found using tabulation = " + csvj_tab(arr));
    }
    
    
    
    // climb stair with var jump memoization
    public static int csvj_mem(int src, int[]jumps,int[]qb){
        
        // base case
        if(src == jumps.length){
            return 1;
        }
        
        // we can't use 0 for unsolved as 0 can be answer
        //thus we use -1
        if(qb[src] != -1){
            return qb[src];
        }
        
        int total =0;
        
        // if given jump is possible
        for(int k=1;k<=jumps[src] && src +k <= jumps.length;k++){
            int ntodw = csvj_mem(src+k,jumps,qb);
            total += ntodw;
        }
        
        qb[src] = total;
        
        return total;
    }
    
    // tabulation
    public static int csvj_tab(int[] jumps){
        
        int n = jumps.length;
        int[] dp = new int[n+1];
        
        // solving smallest problem
        dp[n] = 1; // ways to go to dest from dest
        
        // finding jumps
        for(int i=n-1; i >=0; i--){
            for(int j=1; j<= jumps[i] && i+j <= n; j++){
                // adding rest of the ways after the jump
                dp[i] += dp[i+j]; 
            }
        }
        
        // returning the largest problem
        return dp[0];
    }
    


}