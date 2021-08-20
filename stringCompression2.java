import java.util.*;

public class stringCompression2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String str = scn.next();
		System.out.println(compression("Compression 1: " + str));
	}
    
    
	public static String compression(String str){
		
		StringBuilder ans = new StringBuilder("");
        // a counter that counts occurence of same char 		
		int count = 1;
		for(int i=0; i<str.length()-1; i++){
		    char curr = str.charAt(i);
		    char next = str.charAt(i+1);
		  //  if char is same cont ++
		    if(curr == next){
		        count++;
		    }
		  //  when new char met add the prv char to ans
		    else{
		        ans.append(curr);
		      //  if count > 1 then append count too
		        if(count > 1){
		            ans.append(count);
		        }
		      //  as new char has been met reset count to 1
		        count = 1;
		    }
		}
		
        //as loop was till 2nd last append the last char to ans
		char last = str.charAt(str.length()-1);
		ans.append(last);
		
        //as count is global can be accesed here 
        // if count > 1 append count too
		if(count > 1){
		    ans.append(count);
		}

		return ans.toString();
	}
	

}