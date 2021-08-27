import java.util.*;

public class wPattern {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        
        for(int i=1; i<=n; i++){
            
            for(int j=1; j<=n; j++){
                
                // extreme cols
                if(j==1 ||j==n){
                    System.out.print("*	");
                }
                   

                // lower half rows => diagonal 
                else if(i > n/2 && (i==j || i+j == n+1)){
                    System.out.print("*	");
                }
                
                else{
                    System.out.print("	");
                }
            }
            System.out.println();
        }

    }
}