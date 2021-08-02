import java.util.*;

public class anyToDec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int res = anyBaseToDec(n,b);
        System.out.println(res);
    }

    public static int anyBaseToDec(int n, int b) {
        int res=0;
        int pw = 1;
        
        while(n>0){
            // getting quivalent dec for digs
            // divide by destination
            int dig = n%10;
            // removing treated digs
            n = n/10;

            // positioning the res
            res += dig*pw;
            
            // multiply with exsisting base
            pw = pw*b;
        }
        return res;
    }

    
}

