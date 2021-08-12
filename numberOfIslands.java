import java.util.*;

public class numberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        
        int[][]islands = new int[n][m];
        System.out.println("Enter 0=> water & 1=> land for each box: ");

        for(int i = 0; i < islands.length; i++){
            for(int j = 0; j < islands[0].length; j++){
                System.out.print("Input for index ("+i+","+j+") : ");
                islands[i][j] = sc.nextInt();
            }
        }

        System.out.println("For this given input : ");
        for(int i = 0; i < islands.length; i++){
            for(int j = 0; j < islands[0].length; j++){
                System.out.print(islands[i][j] + " ");
            }
            System.out.println();
        }

        int res = countIslands(islands);
        System.out.println("Number of island present is:" + res);
    }

    public static int countIslands(int[][] islands) {

        int counter = 0;
        int n = islands.length;
        int m = islands[0].length;
        boolean[][] visited = new boolean[n][m];

        // traversing through islands
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                // finding lands and making sure it is unvisited
                if(islands[i][j] == 1 && visited[i][j] == false){

                    // go and find all neighbouring lands of i,j and mark them visited
                    travel(i,j,islands,visited);

                    // formed 1 island
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void travel(int row, int col, int[][] islands, boolean[][] visited){

        // -ve base case
        // (1.) out of islands or (2.) is water or (3.) is already visited
        if(row<0 || col<0 || row >= islands.length || col >= islands[0].length || islands[row][col] == 0 ||visited[row][col] == true){
            return;
        }

        visited[row][col] = true;
        travel(row-1,col,islands,visited); // top
        travel(row,col-1,islands,visited); // left
        travel(row+1,col,islands,visited); // down
        travel(row,col+1,islands,visited); // right


    }
}
