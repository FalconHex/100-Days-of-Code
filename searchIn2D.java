import java.util.*;

public class searchIn2D {
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = scn.nextInt();
        System.out.print("Ennter number of columns: ");
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        System.out.println("Enter elements: ");
        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        System.out.print("Enter element to find: ");
        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }

    public static boolean search(int[][]matrix,int target) {
        
        // to find potenital row 
        // elem lies between first and last column of this row
        int potRow = findRow(matrix, target);
        
        // if there is no such row => element does not exsist
        if(potRow == -1){
            return false;
        }
        
        // find the index of the elemet in the selected row
        boolean ans = findElem(matrix, target, potRow);
        
        return ans;
    }
    
    // funtion to traverse rows and find potential row 
    // based on first and last value
    public static int findRow(int[][]matrix, int target){
        int low = 0;
        int high = matrix.length - 1;
        int lastCol = matrix[0].length - 1;
        
        // binary search by comparing target to first and last cols of row
        while (low <= high){
            int mid = low + (high - low)/2;
            
            if(target >= matrix[mid][0] && target <= matrix[mid][lastCol]){
                return mid;
            }
            else if (target < matrix[mid][0]){
                high = mid - 1;
            }
            else{
                low  = mid +1;
            }
        }
        
        return -1;
    }
    
    
    // Funtion to search target in the potential row
    public static boolean findElem(int[][]matrix, int target, int potRow){
        int low = 0;
        int high = matrix[0].length-1;
        
        // binary search to find elem in the given row
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(target == matrix[potRow][mid]){
                return true;
            }
            else if(target < matrix[potRow][mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }

}