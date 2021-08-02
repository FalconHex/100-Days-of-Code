import java.util.*;

public class anyBaseAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int res = add(b, n1, n2);
        System.out.println(res);
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
