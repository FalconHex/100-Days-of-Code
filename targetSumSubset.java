import java.util.*;

public class targetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array : ");
        for(int i=0 ; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum : ");
        int target = sc.nextInt();

        System.out.println("Subsets having sum = " + target + " are :");

        gss(arr,0,"",0,target);
    }

    public static void gss(int[] arr, int idx, String ss, int sos, int target){

        // base case
        if(idx == arr.length){
            if(sos == target){
                System.out.println(ss + ".");
            }
            return;
        }

        // -ve base case
        if(sos > target){
            return;
        }
        
        // yes call
        gss(arr, idx+1, ss+arr[idx]+", ", sos+arr[idx], target);

        // no call
        gss(arr, idx+1, ss, sos, target);
    }
}
