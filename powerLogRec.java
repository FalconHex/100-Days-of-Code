import java.util.*;

public class powerLogRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int res = power(n,p);
        System.out.println(res);
    }

    public static int power(int n, int p) {

        // base case
        if(p==0) return 1;
        
        // faith: gives n^(p/2)
        int nd2 = power(n ,p/2);
        int res = 0;
        
        // if power was even simly multiply above result with itself
        if(p%2 == 0) {
            res = nd2*nd2;
        }
        // if power was odd multiply result with itself then with n
        else{
            res = nd2*nd2*n;
        }
        return res;
    }
}
