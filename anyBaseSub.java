import java.util.*;

public class anyBaseSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int res = diff(b,n1,n2);
        System.out.println(res);
    }

    public static int diff(int b,int n1,int n2) {
        
        int c= 0; //carry variable
        int res = 0; // final result
        int pw=1; // positioning variable

        // we need to do n2-n1
        // thus n2> n1 => loop till n2 exsists
        while(n2>0){
            
            // taking last didits from n1 & n2
            int d1 = n1%10;
            n1 = n1/10;

            int d2 = n2%10;
            n2 = n2/10;

            int diff = 0;
            
            // if past borrow is taken awway from d2 and still it's big enough
            // normal subtract
            if((d2+c) >= d1){
                diff = (d2+c)-d1;
                c=0;
            }
            // take a borrow from next numbers and give it a carry of -1
            else{
                diff = (d2+b+c) - d1;
                c=-1;
            }

            // adding the obtained res to it's correct position
            res += diff*pw;
            pw = pw*10;
        }
        return res;
    }
}
