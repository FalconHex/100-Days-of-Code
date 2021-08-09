import java.util.*;

public class mazePathsRec{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        ArrayList<String> res = getPaths(0,0,n-1,m-1);
        System.out.println("Paths to reach destination are: ");
        System.out.println(res);
    }

    public static ArrayList<String> getPaths(int sr, int sc, int dr, int dc) {

        // +ve base case => reached destination
        // being at dest. there is still 1 way to reach dest i.e don't do anything
        if(sr == dr && sc == dc){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        // -ve base case => went out of the matrix
        if(sr>dr || sc>dc){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }    
        
        // finds all the paths from horizontal neighbors to destination
        ArrayList<String> hntod = getPaths(sr, sc+1, dr, dc);
        // finds all the paths from vertical neighbors to destination
        ArrayList<String> vntod = getPaths(sr+1, sc, dr, dc);

        ArrayList<String> stod = new ArrayList<String>();

        // add h in front of paths from horizontal neighbors to destination
        for(int i=0; i<hntod.size(); i++){
            stod.add('h' + hntod.get(i));
        }

        // add v in front of paths from vertical neighbors to destination
        for(int i=0; i<vntod.size(); i++){
            stod.add('v' + vntod.get(i));
        }

        return stod;
    }
}