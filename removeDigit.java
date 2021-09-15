import java.util.*;
public class removeDigit {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 4 digit number: ");
        int n = sc.nextInt(); 
        int max = Integer.MIN_VALUE;
        System.out.println("Checking for number: "+n);
        
        for(int i=1;i<=4;i++){
            int temp = n;
            // making a div to remove one digit from given number
            int div = (int)Math.pow(10,i);
            // storing the digit to be removed
            int r = temp%div;
            // removing the digit
            int q = temp/div;
            // rem num with added 0s to add left over num
            int remNum = q*(div/10);
            // removing the 1st dig from left of remainder
            // as that was the dig to be removed
            int toAdd = r%(div/10);
            int ans = (remNum+toAdd);
            System.out.println("After removing digit at index "+i+" from right side, number is: "+ ans);
            max = Math.max(max,ans);
        }
        System.out.println("Maximum 3 digit no. is: "+ max);
    
    }
}
