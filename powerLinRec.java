import java.util.*;

public class powerLinRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int res = power(n,p);
        System.out.println(res);
    }

    public static int power(int n, int p){

        // base case: n^0 = 1
        if(p==0) return 1;

        // faith: give n^(p-1)
        int pm1 = power(n,p-1);
        // my work: multiply n to above ans
        int res = n*pm1;

        return res;
    }
}
