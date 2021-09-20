// An urn contains 8 balls : 4 red , 2 blue and 2 green. Now n balls are drawn out of the urn. 
// Calculate the probability that out of n drawn balls exactly x balls are red.

import java.util.Scanner;

public class prob {
    public static void main (String[] args) {
    
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of balls drawn : ");
        int n = scn.nextInt();
        System.out.print("Enter nummber of red balls required : ");
        int x = scn.nextInt();

        // numerator   : choosing x balls from 4 red balls * choosing remaining balls from n-x => 2 + 2 other balls 
        double num = nCr(4, x) * nCr(4, n-x);
        // denominator : all possible ways to choose n balls from 8 balls        
        double den = nCr(8, n);                      

        int ans = (int)((num / den)*100);
        System.out.print("Probability of getting "+n+" red balls from "+x+" balls = "+ ans);

    }

    // this will be combination nCr
    public static double nCr(int n, int r){       
    
        double x = fo(n) / ( fo(r) * fo(n-r) );
        return x;
    }

    // this will be the factorial
    public static int fo(int n){                  
    
        int f = 1;
        for(int i = 1; i <=n; i++){
            f = f*i;
        } 
        return f;
    }
}