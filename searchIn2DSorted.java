import java.util.*;
public class searchIn2DSorted {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimension for square matrix: ");
        int n = sc.nextInt();
        int[][]arr = new int[n][n];
        
        System.out.println("Enter elements: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Enter element to find: ");
        int elem = sc.nextInt();  
        search(arr,elem);
    }
    
    public static void search(int[][]arr, int elem){
        
        int row =0;
        int col = arr[0].length-1;
        
        // checks for not going out of the matrix
        while( row < arr.length && col > 0){
            
            if(elem == arr[row][col]){
                System.out.println("Element was found at : ");
                System.out.println("row: " + row);
                System.out.println("col: " +col);
                return;
            }
            // if my elem is smaller and matrix is sorted then
            // it is not possible for my element to be either at
            // 1) Right of that index, or at any row below it
            else if (elem  < arr[row][col]){
                col--;
            }
            // if my elem is greater than my index my elem will
            // definetly be any row above the index
            else{
                row++;
            }
        }
        System.out.println("Not Found");
    }

}