import java.util.*;

public class sort012s {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter 0, 1 or 2 at :");
        for(int i = 0;i < n; i++){
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }

        sort012(arr);
        print(arr);
    }
    
    public static void sort012(int[] arr){       
        // range after sort
        // 0 to j-1 => 0s
        // j to i-1 => 1s
        // k+1 to end => 2s
        int i = 0; // ++ when finds 1
        int j = 0; // ++ when finds 0
        int k = arr.length - 1; // -- when finds 2
        while(i <= k){
            if(arr[i] == 1){
                i++;
            }
            else if(arr[i] == 0){
                swap(arr, i, j);
                i++; 
                j++;
            }
            else{
                swap(arr, i, k);
                k--;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    

}