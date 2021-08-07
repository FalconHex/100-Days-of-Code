import java.util.*;

public class lastIdxRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to find: ");
        int elem = sc.nextInt();

        int res = find(arr, elem,0);
        System.out.println(elem + " was last found at index " + res);
    }

    public static int find(int[] arr, int elem, int idx) {

        if(idx == arr.length){
            return -1;
        }

        int pidx = find(arr, elem, idx+1);

        if(pidx != -1) {
            return pidx; 
        }
        else{
            if(arr[idx] == elem){
                return idx;
            }
            else{
                return -1;
            }
        }
    }
}
