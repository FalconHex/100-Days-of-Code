import java.util.*;

public class mazePathsJumpsRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions of the maze: ");
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        System.out.println("All the paths to destination are: ");
        getPaths(0,0,n-1,m-1,"");
    }

    public static void getPaths(int sr, int sc, int dr, int dc, String path) {

        // base case
        if(sr==dr && sc == dc) {
            System.out.println(path);
            return;
        }

        // horizontal move
        for(int h=1; h+sc <= dc; h++){
            getPaths(sr, sc+h, dr, dc, path+"h"+h+"-");
        }

        // vertical move
        for(int v=1; v+sr <= dr; v++){
            getPaths(sr+v, sc, dr, dc, path+"v"+v+"-");
        }

        // diagonal move
        for(int d=1; sr+d <= dr && sc+d <= dc; d++){
            getPaths(sr+d, sc+d, dr, dc, path+"d"+d+"-");
        }
    }
}
