import java.util.*;
public class decRecursion {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDec(n);
    }

    public static void printDec(int n) {

        // base case
        if(n < 0){
            return;
        }
        // my work
        System.out.println(n);
        // faith: a func. to print all num from n-1 
        printDec(n-1);
    }
}
