import java.util.*;
public class floodfill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        System.out.println("Fill the matrix with 0s and 1s :");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print("Enter value for index ("+i+","+j+") :");
                arr[i][j] = sc.nextInt();
            }
        }

        // array to maintain visit check
        boolean[][] visited = new boolean[n][m];

        System.out.println("All the paths to reach destination are: ");
        dispPaths(arr,0,0,"",visited);
    }

    public static void dispPaths(int[][] maze, int row, int column, String path, boolean[][] visited) {
        // -ve base case
        // (1.)out of array or (2.)is an obstacle or (3.)is already visited
        if(row <0 || column <0 || row == maze.length || column == maze[0].length || maze[row][column] == 1 || visited[row][column] == true) {
            return;
        }
        // +ve base case
        if(row == maze.length-1 && column == maze[0].length-1){
            System.out.println(path);
            return;
        }
        // marking as visited
        visited[row][column] = true;
    
        dispPaths(maze, row-1, column, path+"t",visited); // top
        dispPaths(maze, row, column-1, path+"l",visited); // left
        dispPaths(maze, row+1, column, path+"d",visited); // down
        dispPaths(maze, row, column+1, path+"r",visited); // right

        // marking as unvisited
        visited[row][column] = false;
    }
}
