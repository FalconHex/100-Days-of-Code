import java.util.*;

public class spanArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        span(arr);
    }

    public static void span(int[] arr) {

        // finding max element
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i]; 
            }
        }

        // finding min element
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i]; 
            }
        }

        System.out.println(max-min);
    }
}
