import java.util.*;
public class pascalTriangle{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int n = sc.nextInt();
        int sp = n-1;
        
        for(int i=0; i<n; i++)
        {
            int icj =1;

            for (int k = 0; k<sp; k++) {
                // for left spacing
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++)
            {
                System.out.print(icj+" ");   
                int icjp1 = (icj * (i-j))/(j+1);
                icj = icjp1;
                
            }
            System.out.println();
            sp--;           
        }
    }
}