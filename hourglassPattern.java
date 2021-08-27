import java.util.*;

public class hourglassPattern{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     System.out.print("Enter number of columns: ");
     int n = scn.nextInt();
     
     int st = n;
     int sp = 0;
     
     for(int i=1; i<=n; i++){
         
        for(int j=1; j<=sp; j++){
            System.out.print("	");
        }
        
        for(int k=1; k<=st; k++){
            
            if(i>1 && i<=(n/2) && k>1 && k<st){
                System.out.print("	");
            }
            else{
                System.out.print("*	");
            }
            
        }
        
        System.out.println();
        
        if(i <= n/2){
            st = st-2;
            sp++;
        }
        else{
            st = st+2;
            sp--;
        }
     }

 }
}