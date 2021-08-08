import java.util.*;

public class subseqRec{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();

        ArrayList<String> ssq = gss(s);
        System.out.println("Substrings of "+s+" are: ");
        System.out.println(ssq);
    }
    public static ArrayList<String> gss(String s){

        // ssq of blank is 1 and it is ""  itself
        if(s.length() == 0){
            ArrayList<String> bans = new ArrayList<String>();
            bans.add("");
            return bans;
        }
        
        // taking out the first char
        char first = s.charAt(0);
        // getting rest of the string
        String ros  = s.substring(1);

        // faith: getting subsequence of ros (string - first char)
        ArrayList<String> rans = gss(ros);

        // var to store my answer
        ArrayList<String> myans = new ArrayList<String>();

        // adding all the subseq in which my first char do not participate
        for(int i = 0; i < rans.size(); i++){
            myans.add(rans.get(i));
        }
        
        // adding all the subseq in which my first char do not participate
        for(int i = 0; i < rans.size(); i++){
            myans.add(first+rans.get(i));
        }

        return myans;
    }
}