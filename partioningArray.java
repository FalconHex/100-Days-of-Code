import java.util.*;
public class partioningArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter element at: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Index "+ i+" : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter pivot point: ");
        int pivot = sc.nextInt();

        int[]res = part(arr, pivot);

        System.out.println("Partitoned array: ");
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + "|");
        }
    }

    public static int[] part(int[] arr, int pivot){
        // we make 2 pointers i & j
        // i to end = unknown elements
        // j to i-1 = elem > pivot
        // 0 to j-1 = elem <= pivot 
        int i = 0;
        int j = 0;

        while(i < arr.length) {
            if(arr[i] > pivot){
                i++;
            }
            else{
                swap(arr, i, j);
                i++;
                j++;
            }
            
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        System.out.println("Swapping " + arr[i] + " and" + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
