import java.util.*;
public class merge2Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array 1: ");
        int n = sc.nextInt();
        int[]arr1 = new int[n];

        System.out.println("Enter element of array 1 for :");
        for(int i = 0; i < arr1.length; i++) {
            System.out.print("Index "+ i+" : ");
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of array 2: ");
        int m = sc.nextInt();
        int[]arr2 = new int[m];

        System.out.println("Enter element of array 2 for :");
        for(int i = 0; i < arr2.length; i++) {
            System.out.print("Index "+ i+" : ");
            arr2[i] = sc.nextInt();
        }

        merge(arr1, arr2);

    }

    public static void merge(int[]arr1, int[] arr2){

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

        System.out.println("Merged sorted array is :");
        for(int i = 0; i < merged.length; i++){
            System.out.print(merged[i] + " | ");
        }
    }
}
