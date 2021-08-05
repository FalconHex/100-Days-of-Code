import java.util.*;

public class subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter element pf array: ");
        for(int i = 0; i <arr.length; i++){
            arr[i] = sc.nextInt();
        }

        dispSubarray(arr);
    }

    public static void dispSubarray(int[] arr){

        System.out.println("Subarrays: ");
        // loop to control start point
        for(int i = 0; i<arr.length; i++){
            // loop to control end point
            for(int j=i; j<arr.length; j++){
                // loop to display elements in that range
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}