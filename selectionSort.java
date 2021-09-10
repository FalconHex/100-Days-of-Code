import java.util.*;
public class selectionSort {
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

    // start index is considerd smallest
    // find actual smallest and swap
    public static void sort(int[] arr){

        // from 1st elem to 2nd last
        for(int i = 0; i < arr.length-1; i++){
            int mi = i; //index of min elem
            for(int j=i+1; j<arr.length; j++){
                if(isSmaller(arr, j, mi)){
                    mi = j;
                }
            }

            swap(arr, i, mi);
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
