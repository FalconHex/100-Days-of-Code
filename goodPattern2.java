import java.util.*;
public class goodPattern2 {
    
    private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
			Thread.currentThread().interrupt();
		}
	}
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter an even number: ");
        int n = scn.nextInt();
        int decLimit = n+1; //limits dec 
        int constVal = n; 

        for(int i=1; i<=(2*n - 1); i++) {
            
            sleep(200);
            int x = 0;

            // decreasing
            for(int dec=n; dec >= decLimit; dec--) {
                sleep(500);
                if(dec % 2 == 1){
                    System.out.print("#\t");
                }else{
                    System.out.print(dec +"\t");
                }
                
                x++;
            }

            // constants
            for(int con=1; con<= ((2*n) -1 -(2*x)); con++) {
                sleep(500);
                if(constVal % 2 == 1){
                    System.out.print("#\t");
                }else{
                    System.out.print(constVal + "\t");
                }
                
            }

            // increasing
            for(int inc=decLimit; inc<=n; inc++) {
                sleep(500);
                if(inc % 2 == 1){
                    System.out.print("#\t");
                }else{
                    System.out.print(inc + "\t");
                }
                
            }

            System.out.println();
            
            if(i < n) {
                decLimit--;
                constVal--;
            }
            else{
                decLimit++;
                constVal++;
            }
            
            
        }
    }
}