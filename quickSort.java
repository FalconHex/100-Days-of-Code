import java.util.*;
public class quickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements ");
        int n = sc.nextInt();

        int[]arr = new int[n];
        System.out.println("Enter element for: ");
        for(int i=0; i<arr.length; i++){
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length-1);
        System.out.println("Sorted array : ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
    }

    public static void sort(int[] arr, int lo, int hi){
        // base case
        if(lo >= hi){
            return;
        }
        int pivot = arr[hi]; // making last elem of arr as pivot
        int pi = partition(arr, pivot, lo, hi); // partitioning the given array
        sort(arr, lo, pi-1); // sorting the lower half
        sort(arr, pi+1, hi); // sorting the bigger half
    }

    // function to partition the given array on basis of pivot
    public static int partition(int[] arr, int pivot, int lo, int hi) {
        
        System.out.println("Pivot -> " + pivot);
        // setting i and j to first elem
        int i = lo, j = lo;
        while (i <= hi) {
        //   elem <= elem at pivot
            if (arr[i] <= pivot) {
                // swap their index
                swap(arr, i, j);
                i++;
                j++;
            } 
            else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // func to swap elem while partioning Array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
