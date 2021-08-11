import java.util.*;

public class mazePathsRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions of the maze: ");
        System.out.print("Enter number of rows of the maze: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns of the maze: ");
        int m = sc.nextInt();

        System.out.println("All the paths to reach destination are : ");
        getPaths(0,0,n-1,m-1,"");

    }

    public static void getPaths(int sr, int sc, int dr, int dc, String path){

        if(sr == dr && sc == dc){
            System.out.println(path);
            return;
        }
        
        // moving horizontaly
        if(sc+1 <= dc){
            getPaths(sr, sc+1, dr, dc, path + "h");
        }

        // moving vertically
        if(sr+1 <= dr){
            getPaths(sr+1, sc, dr, dc, path + "v");
        }
    }
}
