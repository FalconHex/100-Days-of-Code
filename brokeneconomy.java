import java.util.*;

public class brokeneconomy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.print("Enter elements: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        disp(arr,num);
    }

    public static void disp(int[]arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int ceil = 0;
        int floor = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            // if given num is still bigger than mid elem 
            // we check only the portion right to it
            if(num > arr[mid]){
                low = mid+1;
                floor = arr[mid];
            }
            // if the num is smaller than the mid elem
            // we check only the left portion
            else if(num < arr[mid]){
                high = mid-1;
                ceil = arr[mid];
            }
            // if number exsists in array and is found
            else{
                ceil = arr[mid];
                floor = arr[mid];
                return;
            }
        }
        
        System.out.println(ceil);
        if(ceil != floor){
            System.out.println(floor);
        }
    }
    
}

// ceil is the num just bigger than the number if it doesent exsist in array
// floor is the num just smaller than the number if it doesent exsist in array
