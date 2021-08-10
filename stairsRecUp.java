import java.util.*;
public class stairsRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        System.out.println("All the ways to reach destination are: ");
        getpath(n,"");
    }
    public static void getpath(int n, String path) {
        // base case
        if(n == 0){
            System.out.println(path);
            return;
        }       
        // if I'm atleast at stair 1 above dest => take jump of 1
        if(n >= 1){
            getpath(n-1, path+"1");
        }
        // if I'm atleast at stair 2 above dest => take jump of 2
        if(n>=2){
            getpath(n-2, path+"2");
        }
        // if I'm atleast at stair 3 above dest => take jump of 3
        if(n>=3){
            getpath(n-3, path+"3");
        }
    }
}
