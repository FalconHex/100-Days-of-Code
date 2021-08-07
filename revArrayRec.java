import java.util.*;

public class revArrayRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr= new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enterd array in reverse order: ");
        revDisp(arr,0);
    }

    public static void revDisp(int[]arr, int idx){
        // base case
        if(idx == arr.length){
            return;
        }

        // faith: func displays array in rev order till index 1
        revDisp(arr,idx+1);
        // my work: printing the 1st elem 
        System.out.print(arr[idx]+" ");
    }
}
