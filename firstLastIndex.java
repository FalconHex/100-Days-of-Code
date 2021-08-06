import java.util.*;

public class firstLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        disp(arr, num);

    }

    public static void disp(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;

        int fi = -1;

        while(low < high) {
            int mid = low + (high - low)/2;

            if(num > arr[mid]) {
                low = mid+1;
            }

            else if(num < arr[mid]) {
                high = mid-1;
            }

            else{
                fi = mid;
                high = mid-1;
            }
        }
        System.out.println("First index of " + num + " is: "+fi);

        low = 0;
        high = arr.length-1;
        
        int li= -1;
        while(low < high) {
            int mid = low + (high - low)/2;

            if(num > arr[mid]) {
                low = mid+1;
            }

            else if(num < arr[mid]) {
                high = mid-1;
            }

            else{
                li = mid;
                low = mid+1;
            }
        }
        System.out.println("Last index of " + num + " is: "+li);
    }
}
