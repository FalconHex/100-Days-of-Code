import java.util.*;
public class anyBaseDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int b = sc.nextInt();
        System.out.print("Enter numerator: ");
        int n = sc.nextInt();
        System.out.print("Enter denominator: ");
        int d = sc.nextInt();

        int res = div(b, n, d);
        System.out.println(n + " divided by " + d + " in base "+ b + " = "+ res);
    }

    public static int div(int b, int n, int d) {

        int q = 0; // quotient
        // till num remains
        while(n >= d){
            // we keep subtracting div from numerator
            n = sub(b, n , d);
            // and increase quotient by 1
            q = add(b, q, 1);
        }
        return q;
    }

    public static int sub(int b, int n, int d) {

        int c = 0; //carry var
        int res = 0; //final result var
        int pw = 1; // placment var

        while(n > 0){
            // taking 1 digit out at a time
            int d1 = d%10;
            d = d/10;

            int d2 = n%10;
            n = n/10;

            int dif = 0;

            // if after dealing with carry d2 is still bigger 
            // normal sub with carry = 0
            if((d2+c) >= d1) {
                
                dif = (d2+c)-d1;
                c=0;
            }
            else{
                dif = (d2+b+c) - d1;
                c=-1;
            }
            res += dif*pw;
            pw = pw*10;
        }
        return res;
    }

    public static int add(int b, int n1, int n2) {

        int c = 0; //carry var
        int res = 0; //final res var
        int pw = 1; //placment var

        // loop keeps running till any of the num exsists
        while(n1>0 || n2>0 || c>0){
            
            // getiing unit digit in var d1
            int d1 = n1%10;
            // removing that digit from og n1
            n1 = n1/10;

            // same as above with n2
            int d2 = n2%10;
            n2 = n2/10;

            // calc: adding unit digits and carry:(if any)
            int sum = c + d1 + d2;
            
            // if tot sum get more that that allowed in num system of given base
            // base times of that is send as carry for next dig
            c = sum/b;
            
            // % makes sure that sum stays in range of allowed digits of the given base
            res += sum%b * pw;
            
            // increasing power by 10 times to place res of next digits one step ahead
            pw = pw*10;
        }
        return res;
    }
}
