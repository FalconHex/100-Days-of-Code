import java.util.*;
public class insertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elem in :");
        for(int i = 0; i < n; i++) {
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }

        sort(arr);
    }

    // 1st elem is considerd sorted
    // from next elem we see where to place it in array formed till now
    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++) {
            for(int j=i-1; j >= 0; j--){
                if(isGreater(arr,j,j+1)){
                    swap(arr,j,j+1);
                }
            }
        }
        print(arr);
    }

    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        System.out.println("Sorted array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ "|");
        }
    }
}
