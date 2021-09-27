import java.util.*;
public class intersectArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array 1 : ");
        int n = sc.nextInt();
        int[]arr1 = new int[n];
        System.out.println("Enter elemnt at :");
        for(int i = 0; i < arr1.length; i++) {
            System.out.print("Index "+i + " : ");
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter number of elements in array 2 : ");
        int m = sc.nextInt();
        int[]arr2 = new int[m];
        System.out.println("Enter elemnt at :");
        for(int i = 0; i < arr2.length; i++) {
            System.out.print("Index "+i + " : ");
            arr2[i] = sc.nextInt();
        }

        System.out.println("Intersection of array 1 & array 2 : ");
        findIntersect(arr1, arr2, n, m);
    }

    public static void findIntersect(int[]arr1, int[]arr2, int n, int m) {
        int i = 0;//index for arr1
        int j = 0;//index for arr2

        while(i<n && j<m) {
            // if elem of arr1 is small there exsists no elem in arr2 = to it any further
            // thus inc arr1's index
            if(arr1[i]<arr2[j]){
                i++;
            }
            // if elem of arr2 is small there exsists no elem in arr1 = to it any further
            // thus inc arr2's index
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                System.out.print(arr1[i] + " | ");
                i++;
                j++;
            }
        }
    }
}
