import java.util.*;

public class decIncRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        disp(n);
    }
    
    public static void disp(int n) {

        // base case
        if(n < 0) return;
        
        // my work 1
        System.out.println(n);
        // faith: prints all num from n-1 to 0 then 0 to n-1
        disp(n - 1);
        // my work 2
        System.out.println(n);
    }
}
