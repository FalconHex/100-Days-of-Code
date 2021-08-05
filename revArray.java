import java.util.*;

public class revArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        dispRev(arr);
        sc.close();
    }
    public static void dispRev(int[] arr){
        
        // getting index of first and last elem
        int start = 0;
        int last = arr.length - 1;

        // replacing 1st and last elem
        // rpeeating after getting to inner index each time 
        while(start < last){
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;

            start++;
            last--;
        }
        
        System.out.println("Array in reverse: ");
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
        
    }
}