import java.util.*;

public class stringCompression1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String str = scn.next();
		System.out.println(compression("Compression : " + str));
		
	}
    
    public static String compression(String str){

		StringBuilder ans = new StringBuilder("");
        // checking all adjacent chars till 2nd last elem
        
        // loop till second last char of string
        for(int i=0; i<str.length()-1; i++){
            char curr = str.charAt(i);
            char next = str.charAt(i+1);
            
            // when next char isn't same append that char to ans
            if(curr != next){
                ans.append(curr);
            }
        }
        
        // as loop ran till 2nd last elem
        // last char is left thus appended
        char last = str.charAt(str.length()-1);
        ans.append(last);
        
        // ans was in StringBuilder form thus changing to String
		return ans.toString();
	}

	
	

}