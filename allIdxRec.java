import java.util.*;

public class allIdxRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter element to find: ");
        int elem = sc.nextInt();

        int[] res = find(arr, elem,0,0);

        // if result elem is of size = 0
        // that means given element was not present in the array
        if(res.length == 0){
            System.out.println(elem+ " was not found in the given array!");
            return;
        }
        else{
            System.out.println(elem+" was found at the following indices: ");
            for(int i = 0; i < res.length; i++){
                System.out.print(res[i]+ " ");
            }
        }
    }

    public static int[] find(int[] arr, int elem,int found, int idx){

        // base case
        // aftyer traversing the whole array
        // we return an araay of size = number of times elem was found
        if(idx == arr.length){
            return new int[found];
        }

        // if the elem is found
        if(arr[idx] == elem){
            // we increase the count of var found => happens while filling the stack
            int[] res = find(arr,elem,found+1,idx+1);

            // we fill the index staring from back of the array => this happens while coming don the stack
            res[found] = idx;
            // after adding index of where elem was found array is returned to the next stack below
            return res;
        }
        // if elem is not found
        else{
            // var ffound remains un-altered => happens whhile filling the stack
            int[] res = find(arr,elem,found,idx+1);

            // array is returned to the next stack below un-alterd
            return res;
        }
    }
}
