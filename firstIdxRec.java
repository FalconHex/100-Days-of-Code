import java.util.*;

public class firstIdxRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to find: ");
        int elem = sc.nextInt();

        int res = find(arr,elem,0);
        System.out.println(elem+" was 1st found at index "+res);
    }

    public static int find(int[] arr,int elem,int idx) {

        // base case
        if(idx == arr.length){
            return -1;
        }

        // if the first elem itself is the one to be found
        // no need to call func recursively 
        if(arr[idx] == elem){
            return idx;
        }
        // faith: finds 1st occurrence if it''s not found at index 0
        else{
            int pidx = find(arr,elem,idx+1);
            return pidx;
        }

    }
}
