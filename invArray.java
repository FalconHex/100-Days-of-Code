import java.util.*;

public class invArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        dispInv(arr);
    }

    public static void dispInv(int[] arr) {

        int[] inv = new int[arr.length];

        // exchanging elem of array withindex of that num
        for (int i = 0; i < inv.length; i++) {
            int elem = arr[i];
            inv[elem] = i;
        }

        System.out.println("Inversed array:  ");

        for(int i = 0; i <inv.length; i++){
            System.out.print(inv[i] + " ");
        }
    }
}
