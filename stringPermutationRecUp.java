import java.util.*;

public class stringPermutationRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();

        System.out.println("Permutations of given string are: ");
        getPerm(str,"");
    }
    public static void getPerm(String str, String res){

        if(str.length() == 0){
            System.out.println(res);
            return;
        }
        
        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);

            getPerm(ros, res+ch);
        }
    }
}
