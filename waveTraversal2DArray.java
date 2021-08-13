import java.util.*;
public class waveTraversal2DArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        
        int[][]arr = new int [r][c];
        
        System.out.println("Enter elememts of matrix: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print("for index ("+i+","+j+") : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Elememts of matrix after wave traversal : ");
        waveDisp(arr);

    }
    
    public static void waveDisp(int[][] arr){
        
        for(int j=0; j<arr[0].length;j++){
            // every even column is printed top to bottom
            if(j%2==0){
                for(int i=0; i<arr.length; i++){
                    System.out.println(arr[i][j] + " ");
                }
            }
            // every odd column is printed bottom to top
            else{
                for(int i=arr.length-1; i>=0; i--){
                    System.out.println(arr[i][j] + " ");
                }
            }
        }
    }


}