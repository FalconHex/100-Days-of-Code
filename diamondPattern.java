import java.util.*;

public class diamondPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int n = scn.nextInt();
        int st = 1;
        int sp = n/2;
        int val = 1;
        
        for(int i=1; i<=n; i++){
            // print spaces
            for(int j=1; j<=sp; j++){
                System.out.print("\t");
            }
            int count = val;
            // print num
            for(int k=1; k<=st; k++){
                System.out.print(count + "\t");
                
                if(k<=st/2){
                    count++;
                }
                else{
                    count--;  
                }
            }
            
            System.out.println();
            
            // cond. to inc or dec
            if(i<=n/2){
                st += 2;
                sp--;
                val++;
            }
            else{
                st -=2;
                sp++;
                val--;
            }
        }

    }
}