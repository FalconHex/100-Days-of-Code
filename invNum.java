import java.util.*;
public class invNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int n = num;
        // var to store inverse of number
        int inv = 0;
        // original position => starts from 1
        int op = 1;

        while(n > 0){
            // original digit => starts from unit place
            int od = n%10;
            
            // inversed position
            int ip = od%10;
            // inversed digit
            int id = op;

            // placing inversed digit at it's inverse position
            inv += id*(int)Math.pow(10,ip-1);
            n = n/10;
            op++;
        }
        System.out.println(num+ " as inversed is: "+ inv);
    }
}
