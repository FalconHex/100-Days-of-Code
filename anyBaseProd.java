import java.util.*;

public class anyBaseProd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b= sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // main function to get product of 2 numbers
        int res = product(b,n1,n2);
        System.out.println(res);
    }

    /* Thinking: (1) get 1 digit of n2
                 (2) multiply this with alll the digits of n1
                 (3) proceed to get next digit of n2
                 (4) before adding the res obtained from multiplying next digit of d2
                     multiply the result by 10 => equivilant to x we place before adding product of single digit
                 (5) Repeat step 4 till all digits of n2 are exhauted */
    
    public static int product(int b,int n1,int n2) {

        int res = 0;
        int pw = 1;

        // we take digits of n2 one by one
        while(n2>0){
            int d2 = n2%10;
            n2 = n2/10;

            // calling a func to multiply all digits 
            // of n1 with last dig of n2 = d2
            int sdp  = singleProd(b,n1,d2);
            
            // calling a func to add the res og n1 and n2
            res = getSum(b,res,(sdp*pw));
            pw = pw*10;
        }
        return res;
    }

    // func to multiply d2 with all digits of n1
    public static int singleProd(int b, int n1, int d2){
        int res = 0;
        int c = 0;
        int pw = 1;

        while(n1>0 || c>0){
            
            int d1 = n1%10;
            n1 = n1/10;

            int prod = (d1*d2)+c;
            // if res> digit allowed in given num sys.
            // getting carry's value
            c = prod/b;

            res += prod%b * pw;
            pw = pw*10;
        }
        return res;
    }

    // function to add the given numbers
    public static int getSum(int b, int n1, int n2){
        int res =0;
        int c=0;
        int pw =1; 

        while(n1>0 || n2>0 || c>0){
            int d1 = n1%10;
            n1= n1/10;

            int d2 = n2%10;
            n2 = n2/10;

            int sum = d1+d2+c;
            c = sum/b;

            res += sum%b * pw;
            pw = pw*10;
        }
        return res;
    }
}
