import java.util.*;
public class bubbleSort {
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

    // each element is compared to next element
    // if found to be smaller swap
    // after each traversal largest elem gets to it's correct posn
    public static void sort(int[] arr) {

        // travels till one item less in array each time
        for(int i=1; i<=arr.length-1; i++) {
            for(int j=0; j<arr.length-i; j++) {
                // commpare if curr elem < next elem
                if(isSmaller(arr, j+1, j)){
                    // swap their position
                    swap(arr,j+1,j);
                }
            }
        }
        print(arr);
    }

    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } 
        else {
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
