import java.util.*;
public class countBinStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of string: ");
        int n = sc.nextInt();

        // bin string should not have consecutive 0s
        int oldZeroCount = 1; //count of bin strings ennding with 0
        int oldOneCount = 1; //count of bin strings ennding with 1

        int count  = findCount(n, oldZeroCount, oldOneCount);
        System.out.println("Total number of binary strings of length "+n+" without consecutive 0s = " + count);
    }

    public static int findCount(int n, int oldZeroCount, int oldOneCount){

        // finding counts for 0s and 1s for length 2 to n
        for(int i=2; i<=n; i++){
            
            // we can't add 0 to a string already ending with 0
            // this only add 1
            int newZeroCount = oldOneCount;
            int newOneCount = oldOneCount + oldZeroCount;

            oldZeroCount = newZeroCount;
            oldOneCount = newOneCount;
        }
        return(oldOneCount+oldZeroCount);
    }
}
