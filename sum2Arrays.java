import java.util.*;

public class sum2Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // input for 1st array
        System.out.print("enter length of 1st array: ");
        int n = sc.nextInt();
        System.out.println("enter elements of 1st array: ");
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("enter length of 2nd array: ");
        int m = sc.nextInt();
        System.out.println("enter elements of 2nd array: ");
        int[] arr2 = new int[m];
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        sum(arr1, arr2);
    }

    public static void sum(int[] arr1, int[] arr2) {

        // making an array for result: size = larger og give 2 arrays +1
        // +1 because if 1sst digit of larger array is say 9 => 9+1=10 thus to store 1 we need extra index
        int len = Math.max(arr1.length, arr2.length)+1;
        int[] res = new int[len];

        // getting vars to store last indexes of all arrays
        int a = arr1.length -1;
        int b = arr2.length -1;
        int r = res.length - 1;
        int c = 0;

        // till indexes are left in result array
        while(r >= 0) {
            
            int ans = 0;
            
            // checking for element in arr1
            // and adding it to ans
            if(a >= 0){
                ans += arr1[a];
            }
            // checking for element in arr2
            // and adding it to ans
            if(b >= 0){
                ans += arr2[b];
            }

            // adding carry from prev digit to ans
            ans += c;

            // if ans > 9 turning it to acceptable single digit num
            int rem = ans%10;
            // getting carry for next digit if any
            c = ans/10;

            // adding to result
            res[r] = rem;
            
            // reducing indexes of all arrays
            a--;
            b--;
            r--; 
        }

        System.out.print("Sum = ");
        // skipping 0 if there is any in 1st index of result
        if(res[0] != 0) {
            System.out.print(res[0]);
        }
        for(int m=1; m<res.length; m++) {
            System.out.print(res[m]);
        }
    }
}
