import java.util.*;

public class anyToAny {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int res = anyToAnyBase(n, b1, b2);
        System.out.println(res);
    }    

    public static int anyToAnyBase(int n, int b1, int b2){

        int inDec = anyToDec(n,b1);
        int inBase2 = decToAny(inDec,b2);
        return inBase2;
    }

    public static int anyToDec(int n, int b){
        int res = 0;
        int pw = 1;

        while(n>0){
            
            // divide by dest base
            int dig = n%10;
            n = n/10;

            res += dig*pw;
            // myltiply with exsisting base
            pw = pw*b;
        }
        return res;
    }

    public static int decToAny(int n, int b){
        int res = 0;
        int pw = 1;

        while(n>0){

            // divide by dest base
            int dig = n%b;
            n = n/b;

            res += dig*pw;
            // multiply with exsisting base
            pw = pw*10;
            
        }
        return res;
    }
}
