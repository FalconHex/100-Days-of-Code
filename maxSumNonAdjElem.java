import java.util.*;
public class maxSumNonAdjElem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int res = findMax(arr);
        System.out.println("Max sum of subset with no adjacent elemnts = " + res);
    }

    public static int findMax(int[] arr) {        
        // 1st elem is already dealt here
        int inc = arr[0]; // var to store sum after including
        int exc = 0; // var to store sum if elem not included
        // traversing from 2nd elem to last
        for(int i = 1; i < arr.length; i++) {
            int ninc = exc + arr[i]; // adding current elem to sum obtained from subset formed by excluding prev elem
            int nexc = Math.max(inc, exc); // storing larger of sum formed by either including or excluding prev elem
            // updating inc and exc
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc, exc);
    }
}
