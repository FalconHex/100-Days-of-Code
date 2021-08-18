import java.util.*;
public class saddlePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimension of array : ");
        int n = sc.nextInt();

        int[][]arr = new int[n][n];
        System.out.println("Enter elements of array : ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("For index ("+i+","+j+") : ");
                arr[i][j] = sc.nextInt();
            }
        }
 
        System.out.println("Saddle point of given array:");
        
        findSaddle(arr);
    }

    public static void findSaddle(int[][] array) {

        for(int i=0; i<array.length; i++) {

            int svc = 0; //smallest value's column
            for(int j=0; j<array[0].length; j++) {
                // finding column of the smallest array in given row
                if(array[i][svc] > array[i][j]) {
                    svc = j;
                }
            }

            // checker
            boolean flag = true;

            // traversing diffrent rows
            for(int k=0; k<array.length; k++) {
                // going only through the column of smallest element
                // to check if it's highest in it's column
                if(array[i][svc] < array[k][svc]) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println(array[i][svc]);
                return;
            }
        }
        System.out.println("Does not exsist !");
    }
}

