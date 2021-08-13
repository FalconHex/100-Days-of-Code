import java.util.*;

public class rotate90Deg2DArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dimension for square matrix: ");
        int n = sc.nextInt();
        
        int[][]arr = new int[n][n];
        
        System.out.println("Enter elememts of matrix: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print("for index ("+i+","+j+") : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Given Matrix: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix after rotating by 90 deg : ");
        disp(arr);
    }


    public static void disp(int[][] arr){
        
        // transpose: loop should only be of upper triangle
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        // exchange number of columns by each row
        for(int i=0; i<arr.length; i++){
            int li = 0;
            int ri = arr[0].length -1;
            
            while(li<ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                
                li++;
                ri--;
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}


