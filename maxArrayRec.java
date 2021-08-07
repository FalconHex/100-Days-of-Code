import java.util.*;

public class maxArrayRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println(":Enter elements of array: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        
        int res = max(arr,0);
        System.out.print("Max elemnt of array is: "+ res);
    }

    public static int max(int[] arr, int idx){

        // base case
        if(idx == arr.length){
            // we need to return min_value as 
            // suppose we send 1 but the array was filled with 0s anf -ve numbs
            // this would lead to max elem = 1 which is wrong
            return Integer.MIN_VALUE;
        }
        
        int res = Integer.MIN_VALUE;

        // faith: find max elem between index 1 and end
        int temp = max(arr,idx+1);
        
        // my work: if first elem is bigger than max found so far make res as first elem
        if(arr[idx] > temp){
            res = arr[idx];
        }else{
            res = temp;
        }

        return res;
    }
}
