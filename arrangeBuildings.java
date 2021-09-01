import java.util.*;
public class arrangeBuildings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of plots in one side: ");
        int n = sc.nextInt();

        int res = findWays(n);
        System.out.println("Number of ways buildings can be arranged = " + res);
    }

    public static int findWays(int n) {
        // arrangment where last plot has building
        int ob = 1;
        // arrangment where last plot has space
        int os = 1;

        for(int i=2; i<=n; i++){
            // a building can only be added if before it there was a space
            int nb = os;
            int ns = os + ob;

            ob = nb;
            os = ns;
        }

        // there are same number of ways to arrange in other side
        // thus take square
        int res = (ob+os)*(ob+os);
        return res;
    }
}
    

