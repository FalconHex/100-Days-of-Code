import java.util.*;
public class getKpcRecUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your keys: ");
        String str = sc.next();

        System.out.println("All possible codes using " + str + " are: ");
        getKpc(str,"");
    }

    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void getKpc(String str, String ans){

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char firstKey = str.charAt(0);
        String restKey = str.substring(1);

        String myCode = codes[firstKey - '0'];

        for(int i = 0; i < myCode.length(); i++){

            getKpc(restKey,ans+myCode.charAt(i));
        }
    }
}
