import java.util.*;

public class goodPattern1 {
    
    // func to make aa delay
    private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
			Thread.currentThread().interrupt();
		}
	}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        int k = 0; // multiplier
        int sv = 0; // value to print

        for(int i=1; i<=n; i++) {
            
            // if n is odd 
            if(n%2 != 0) {
                sv = n*k + 1;
                // if we are in upper half inc multiplier by 2
                if(i <= n/2){
                    k += 2;
                }
                // if we are in mid row dec multiplier by 1
                else if(i == n/2 + 1) {
                    k--;
                }
                // if we are in lower half dec multiplier by 2
                else{
                    k -= 2;
                }
            }

            // if n is even
            if(n%2 == 0) {
                sv = n*k + 1;
                // if we are in upper half inc multiplier by 2
                if(i < n/2){
                    k += 2;
                }
                // if we are in mid row dec multiplier by 1
                else if(i == n/2) {
                    k += 1;
                }
                // if we are in lower half dec multiplier by 2
                else{
                    k -= 2;
                }
            }
        
            // printing
            for(int j=1; j<=n; j++){
                
                sleep(300);
                // for first and last rows
                if(i==1 || i==n){
                    System.out.print(sv +"\t");
                }
                else{
                    // for first and last columns
                    if(j==1 || j==n) {
                        
                        System.out.print(sv +"\t"); 
                    }
                    else{
                        System.out.print("*\t");
                    }
                }
                
                sv++;
            }
            System.out.println();
            sleep(200);
        }
    }
}