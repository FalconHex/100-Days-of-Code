import java.util.*;

public class diff2Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // mking arr 1
        System.out.print("Enter size of 1st array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        System.out.println("Enter elements of 1st array: ");
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = sc.nextInt();
        }

        // making arr 2
        System.out.print("Enter size of 2nd array: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter elements of 2nd array: ");
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = sc.nextInt();
        }

        diff(arr1, arr2);
        
    } 
    
    public static void diff (int[] arr1, int[] arr2){
        
        // making arr 3 for result
        int n3 = Math.max(arr1.length, arr2.length);
        int[] arr3 = new int[n3];

        // getting last indices
        int a = arr1.length-1;
        int b = arr2.length-1;
        int d = arr3.length-1;
        
        // var to maintain carry
        int c = 0;

        // till indexes are left in result
        while (d >= 0){
            
            int diff = 0;
            int num;

            // if numbers of array 1 gets finished use 0 instead
            if(a >= 0){
                num = arr1[a];
            }
            else{
                num = 0;
            }

            // if digit of 2nd array after dealing with carry
            // is still bigger than that of array 2 
            if(arr2[b]+c >= num){
                diff = ((arr2[b]+c) - num);
                c=0;
            }
            else{
                diff = ((arr2[b]+c+10) - num);
                c = -1; 
            }

            arr3[d] = diff;

            a--;
            b--;
            d--;

        }

        System.out.print("Diffrence: ");
        int idx = 0;

        // skipping out all the left 0s
        while(arr3[idx] == 0){
            idx++;
        }

        while(idx < arr3.length){
            System.out.print(arr3[idx]);
            idx++;
        }
    }
}
