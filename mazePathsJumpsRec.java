import java.util.*;
public class mazePathsJumpsRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        ArrayList<String> res = getPaths(0,0,n-1,m-1);
        System.out.println("All the paths from source to destination are: ");
        System.out.println(res);
    }
    public static ArrayList<String> getPaths(int sr, int sc, int dr, int dc){
        // +ve base case => on reaching dest you still can have 1 move = don't move
        if(sr == dr && sc == dc){
            ArrayList<String> bans = new ArrayList<String>();
            bans.add("");
            return bans;
        }
        // no -ve base case as we called func recursilvely in a loop
        // with conditions => proactively thus avoiding a call
        // that leads you outside the matrix 
        ArrayList<String> stod = new ArrayList<>();
        // all horizontal calls
        for(int h=1; sc+h <= dc; h++){
            // all paths from horizontal neighbour
            ArrayList<String> hntod = getPaths(sr, sc+h, dr, dc);

            // adding h and respective jump in front of all paths
            for(int i=0; i<hntod.size(); i++){
                stod.add("h"+ h + hntod.get(i));
            }
        }
        // all vertical paths
        for(int v=1; sr+v <=dr; v++) {
            // all paths from vertical neighbors
            ArrayList<String> vntod = getPaths(sr+v, sc, dr, dc);
            // adding v and respective jump in front of all paths
            for(int i=0; i<vntod.size(); i++){
                stod.add("v"+ v + vntod.get(i));
            }
        }
        // all diagonal paths
        for(int d=1; sr+d <= dr && sc+d <= dc; d++){
            // all paths from diagonal neighbour
            ArrayList<String> dntod = getPaths(sr+d, sc+d, dr, dc);
            // adding d and respective jumps infront of all paths
            for(int i=0; i<dntod.size(); i++){
                stod.add('d'+ d + dntod.get(i));
            }
        }
        return stod;
    }
}
