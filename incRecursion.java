import java.util.*;

public class incRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        printInc(n);
    }

    public static void printInc(int n) {

        // base case
        if(n < 0) {
            return;
        }
        // faith: a func that prints all number till n-1
        printInc(n-1);

        // my work
        System.out.println(n);
    }
}