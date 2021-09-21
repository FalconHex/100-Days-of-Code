import java.util.*;

public class radixSort {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements for : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }
        sort(arr);
        System.out.println("Array sorted completley : ");
        print(arr);
    }
    
    public static void sort(int[] arr) {        
        // to find the max element of array => we know how many times to run the countsort
        int max = Integer.MIN_VALUE;
        for(int val : arr) {
            if(val > max) {
                max = val;
            }
        }
        int exp = 1;
        while(exp < max) {
            countSort(arr, exp);
            exp = exp*10; //to get the desired digit for comparison from each elem
        }
    }

    // countSort
    public static void countSort(int[] arr, int exp) {
        int[] farr = new int[10]; // freq array => stores freq. of each elem which will be b/w 0 and 9

        // filling farr
        for(int i = 0; i < arr.length; i++) {
            farr[arr[i] / exp % 10 ]++; //this finds the digit of elem and compares and increase it's freq
        }

        // transforming freq. arr to prefix sum array => freq of prev elem + freq of current elem
        // this tell the last index where the current elem will be stored => if for elem 3 value is 5 = last 3 will be at index 4
        for(int i=1; i<farr.length; i++) {
            farr[i] += farr[i-1];
        }

        int[] ans = new int[arr.length]; //answer array

        // traversing through given array backwards
        for(int i=arr.length-1; i>=0; i--){
            int pos = farr[(arr[i] / exp % 10)] - 1; // pos where the current elem's freq is stored
            ans[pos] = arr[i]; // placing at correct position
            farr[(arr[i] / exp % 10)]--;//decreasing the freq of the placed element
        }

        // filling the og array
        for(int i=0; i<arr.length; i++){
            arr[i] = ans[i]; 
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    

}