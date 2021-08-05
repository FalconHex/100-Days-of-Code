import java.util.*;

public class rotArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i=0; i< arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value by which to be rotated: ");
        int k = sc.nextInt();

        dispRot(arr,k);
    }

    public static void dispRot(int[] arr, int k){

        // if value to rot > length of array
        // it will always be multiple of length of array
        k = k%arr.length;

        // if rot num is -ve it will be rotating from start
        // that same as rotaring  length - |number of rot| num from end
        if(k<0){
            k = arr.length+k;
        }
        
        // reversing from rot post to end of array
        rev(arr,arr.length-k,arr.length-1);
        // reversing from start to one wlwm before rot post
        rev(arr,0,arr.length-k-1);
        // reversing full array
        rev(arr,0,arr.length-1);

        System.out.println("Array after rotation: ");
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void rev(int[] arr,int start, int last){

        // array reversal
        while(start<last){
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;

            start++;
            last--;
        }
    }
}
