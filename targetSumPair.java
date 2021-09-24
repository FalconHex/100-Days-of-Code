import java.util.*;
public class targetSumPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter element at : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Index "+ i + " : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum : ");
        int tar = sc.nextInt();

        System.out.println("Pairs having sum = " + tar + " are : ");
        findPair(arr, tar);
    }

    public static void findPair(int[]arr, int tar) {
        int li  = 0; //pointer at begining of array
        int ri = arr.length - 1; //pointer at end of array

        Arrays.sort(arr);

        while(li < ri) {
            // if target < sum
            if(arr[li]+arr[ri] > tar) {
                //elem at right index is too big
                ri--;
            }
            else if(arr[li]+arr[ri] < tar) {
                //elem at left index is too small
                li++;
            }
            else{
                System.out.println("=> "+ arr[li]+" , "+arr[ri]);
                li++;
                ri--;
            }
        }
    }
}
