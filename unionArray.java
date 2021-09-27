import java.util.*;
public class unionArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array 1 : ");
        int n = sc.nextInt();
        int[]arr1 = new int[n];

        System.out.println("Enter elements at : ");
        for(int i = 0; i < arr1.length; i++) {
            System.out.print("Index "+i + " : ");
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of array 2 : ");
        int m = sc.nextInt();
        int[]arr2 = new int[m];

        System.out.println("Enter elements at : ");
        for(int i = 0; i < arr2.length; i++) {
            System.out.print("Index "+i + " : ");
            arr2[i] = sc.nextInt();
        }

        System.out.println("Unioun of array 1 & array 2 = ");
        findUnion(arr1, arr2, n, m);
    }

    public static void findUnion(int[] arr1, int[] arr2, int n, int m) {
        int i=0; //index for arr1
        int j=0; //index for arr2

        while(i<n && j<m){
            // if elem of arr1 is smaller print and increment arr1's index
            if(arr1[i] < arr2[j]){
                System.out.print(arr1[i]+ " | ");
                i++;
            }
            // if elem of arr2 is smaller print and increment arr2's index
            else if(arr1[i] > arr2[j]){
                System.out.print(arr2[j]+ " | ");
                j++;
            }
            // if both elem are equal print any and increase both indices
            else{
                System.out.print(arr1[i]+ " | ");
                i++;
                j++;
            }
        }

        // printing leftovers 
        while(i<n){
            System.out.print(arr1[i]+ " | ");
            i++;
        }
        while(j<m){
            System.out.print(arr2[j]+ " | ");
            j++;
        }
    }
}