import java.util.*;

public class barchartArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i <arr.length; i++){
            arr[i] = sc.nextInt();
        }

        barchart(arr);
    }

    public static void barchart(int[] arr){       
        // finding the max elem
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        // we set number of levels = max element
        for(int level = max; level >0; level--){           
            // for each value of elem in the array
            for(int i=0; i<arr.length; i++){               
                // if it's = or greater than value of current array print *
                if(arr[i] >= level){
                    System.out.print("* \t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();       
        }
    }
}