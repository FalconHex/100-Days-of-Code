//for n=3 req o/p => 321112111232111211123
//for n=2 req o/p => 211121112

import java.util.*;

public class zigzagRec {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();

        disp(n);
    }

    public static void disp(int n){

        // base case
        if(n==0) return;

        System.out.print(n);
        disp(n-1);
        System.out.print(n);
        disp(n-1);
        System.out.print(n);
    }
}
