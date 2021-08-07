import java.util.*;

public class arrayRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n  = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enterd array is: ");
        disp(arr,0);
    }

    public static void disp(int[] arr, int idx){

        // base case
        if(idx == arr.length){
            return;
        }

        // my work: printing the first element
        System.out.print(arr[idx] + " ");
        // faith: func will print elements from index 1
        disp(arr, idx+1);
    }
} 
