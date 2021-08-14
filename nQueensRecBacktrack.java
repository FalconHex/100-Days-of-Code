import java.util.*;

public class nQueensRecBacktrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimension for chess board: ");
        int N = sc.nextInt();

        int[][] chess = new int[N][N];

        System.out.println(N + " Queens can safely be placed in given chess board as: ");
        disp(chess,"",0);
    }

    public static boolean isQueenSafe (int[][] chess, int r, int c) {

        // cheking upper columns
        for(int i=r-1; i>=0; i--) {
            if(chess[i][c] == 1){
                return false;
            }
        }

        // checking upper right diagonal
        for(int i = r-1, j=c+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        // checking upper left diagonal 
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
            if(chess[i][j] == 1){
                return false;
            }
        } 

        
        
        // if it's safe
        return true;
    }
    
    
    public static void disp(int[][] chess, String qsf, int row){

        // base case
        if(row == chess.length){
            System.out.println(qsf + "|");
            return;
        }
        
        // traversing through columns
        for(int col =0; col < chess.length; col++){
            // saftey check
            if(isQueenSafe(chess,row,col) == true){
                // placing queen
                chess[row][col] = 1;
                // going to next row to place
                disp(chess, qsf+row+"-"+col+",", row+1);
                // removing the queen when checked for that row;
                chess[row][col] = 0;
            }            
        }
    }
}
