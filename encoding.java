import java.util.*;

public class encoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String str = sc.next();

        System.out.println("Encoded forms : ");
        getEncoded(str, "");
    }

    public static void getEncoded(String str, String res){
        // base case
        if(str.length() == 0){
            System.out.println(res);
            return;
        }

        // flag case => don't proceed further
        if(str.charAt(0) == '0'){
            return;
        }
        
        //I. => Dealing with single digits
        char ch0 = str.charAt(0);
        // getting numeric equivalent for the num in string
        int num = ch0 - '0';
        // finding corresponding alphabet to number
        char mapSingle = (char)(num + 'a' -1);

        // rest of the string after taking out single digit
        String ros1 = str.substring(1);
        getEncoded(ros1, res+mapSingle);


        //II. => Dealing with double digits
        // for 2 digits to be extracted atleast there should be 2 digits
        if(str.length() >= 2){
            char ch1 = str.charAt(1);

            // getting equivalent int values
            int ones = ch1 -'0';
            int tens = ch0 -'0';
            int val = tens*10 + ones;

            // now the obtained value must be <=26
            if(val <= 26){
                String ros2 = str.substring(2);
                char mapDouble = (char)(val + 'a' - 1);
                getEncoded(ros2, res+mapDouble);
            }
        }
        
    }
}
