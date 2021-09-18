import java.util.*;
public class countSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        int big = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;

        System.out.println("Enter element in array for : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Index "+ i + " : ");
            arr[i] = sc.nextInt();
            big = Math.max(big, arr[i]);
            small = Math.min(small, arr[i]);
        }

        sort(arr, small, big);

        System.out.println("Array after sorting : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }

    public static void sort(int[] arr, int small, int big) {
        
        int range = big - small + 1; // range of elements in array
        int[] farr = new int[range]; // freq array => stores freq. of each elem 

        // filling farr
        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] - small; //freq of each elem is stored at index (value of elem - smallest elem);
            farr[idx]++;
        }

        // transforming freq. arr to prefix sum array => freq of prev elem + freq of current elem
        // this tell the last index where the current elem will be stored => if for elem 3 value is 5 = last 3 will be at index 4
        for(int i=1; i<farr.length; i++) {
            farr[i] = farr[i] + farr[i-1];
        }

        int[] ans = new int[arr.length]; //answer array

        // traversing through given array backwards
        for(int i=arr.length-1; i>=0; i--){
            int val = arr[i]; //value in given array
            int pos = farr[val - small]; // pos where the current elem's freq is stored
            int idx = pos - 1; //this is the index where elem should actually be
            ans[idx] = val; // placing at correct position
            farr[val -small]--;//decreasing the freq of the placed element
        }

        // filling the og array
        for(int i=0; i<arr.length; i++){
            arr[i] = ans[i]; 
        }
    }
}