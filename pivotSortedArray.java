import java.util.*;
public class pivotSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[]arr= new int[n];

        System.out.println("Enter element at : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print("Index "+ i + " : ");
            arr[i] = sc.nextInt();
        }

        int pivot = findPivot(arr);
        System.out.println("Pivot of given array : "+ pivot);
    }

    // recursive func
    public static int findPivot(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi){
            int mid = (lo + hi)/2;
            // if hi > mid => value increases after mid = pivot lies left of mid
            // else lies at right
            if(arr[mid] < arr[hi]){
                // discarding right side of mid
                hi = mid;
            }
            else{
                lo = mid + 1; 
            }
        }
        // when we exit the loop only pivot remains
        return arr[hi];
    }
}
