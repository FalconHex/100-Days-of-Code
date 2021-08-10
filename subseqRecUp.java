import java.util.*;

public class subseqRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();

        System.out.println("Subsequence of the given string are: ");
        gss(str,"");
    }

    public static void gss(String str, String ans){

        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        
        // getting the first char of string
        char ch = str.charAt(0);
        // getting rest of the string
        String ros = str.substring(1);

        // fun call when first char participates in subsequence
        gss(ros, ans+ch);
        // fun call when first char does not participate in subsequence
        gss(ros,ans);
    }
}