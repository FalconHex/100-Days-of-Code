import java.util.*;

public class quickSelect {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter element for : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter value of 'k' to find kth smallest element: ");
        int k = sc.nextInt();
        System.out.println(quick(arr, 0, arr.length - 1, k - 1));
    }

    public static int quick(int[] arr, int lo, int hi, int k) {
    
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);

        if(k > pi){
            return quick(arr, pi+1, hi, k);
        }
        else if(k < pi){
            return quick(arr, lo, pi-1, k);
        }
        else{
            return arr[pi];
        }
    }

    // func to partition 
    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        
        while (i <= hi) {
            if (arr[i] <= pivot) {
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

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // printing func
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}