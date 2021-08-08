import java.util.*;

public class getKpcRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the keys: ");
        String keys = sc.next();

        ArrayList<String> res = getKpc(keys);
        System.out.println("All combination using the given keys " + keys + " are:  ");
        System.out.println(res);
    }

    // array havinf coressponding codes for the key
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKpc(String keys){

        if(keys.length() == 0){
            ArrayList<String> bans = new ArrayList<String>();
            bans.add("");
            return bans;
        }
        
        // first key from the given string
        char first = keys.charAt(0);
        // rest of the keys
        String ros = keys.substring(1);

        // stores all the combination formed using rest of the keys
        ArrayList<String> rkpc = getKpc(ros);
        ArrayList<String> myans = new ArrayList<String>();

        // getting code corresponding to first key
        String mycode = codes[first - '0'];

        // getting each char from the code coressponding to first key
        for(int i = 0; i < mycode.length(); i++){
            char mychar = mycode.charAt(i);

            // adding each char one by one infront of all the combination formed by rest of the keys
            for(int j = 0; j < rkpc.size(); j++){
                myans.add(mychar+rkpc.get(j));
            }
        }
        return myans;
    }
}

