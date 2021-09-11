import java.util.*;
public class mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter element of array 1 for :");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }

        int[]sorted = sort(arr, 0, arr.length-1);

        System.out.println("Merge sorted array is :");
        for(int i = 0; i < sorted.length; i++){
            System.out.print(sorted[i] + " | ");
        }
    }

    public static int[] sort(int[] arr, int lo, int hi) {

        // base case 
        if(lo == hi){
            int[]ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        
        int mid = (lo + hi) / 2;
        // first half sorted
        int[] fhs = sort(arr, lo, mid);
        // second half sorted
        int[] shs = sort(arr, mid+1, hi);
        // full sorted array 
        int[] fs = merge(fhs, shs);
        
        return fs;
    }

    public static int[] merge(int[]arr1, int[] arr2){

        int a = 0; // index of array 1
        int b = 0; //index of array 2
        int c = 0; //index of merged array

        int[]merged = new int[arr1.length + arr2.length];

        // runs through both arrays and add to merged in sorted order
        while(a<arr1.length && b<arr2.length){
            if(arr1[a]<arr2[b]){
                merged[c] = arr1[a]; //if arr1 has smaller elem add that
                a++;
                c++;
            }
            else{
                merged[c] = arr2[b]; //if arr2 has smaller elem add that
                b++;
                c++;
            }
        }

        // dealing with left over array
        while(a < arr1.length){
            merged[c] = arr1[a];
            a++;
            c++;
        }

        while(b < arr2.length){
            merged[c] = arr2[b];
            b++;
            c++;
        }

        return merged;
    }
}
