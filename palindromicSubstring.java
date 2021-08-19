import java.util.*;

public class palindromicSubstring {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
		String str = scn.next();
		System.out.println("All palindromic Substrings are: ");
        solution(str);
	}
    
    public static void solution(String str){
        //getting all substrings
        // if first index starts from n last index starts from n+1
		for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String ss = str.substring(i,j);
		      //  checking if substring is palindrome
                if(isPalindrome(ss) == true){
                    System.out.println(ss);
                }
            }
		}
	}
	
	public static boolean isPalindrome(String str){
	    int fi =0;
	    int li =str.length()-1;
	    
	    while(fi<=li){
	        char ch1 = str.charAt(fi);
	        char ch2 = str.charAt(li);
	        
	        if(ch1 != ch2){
	            return false;
	        }else{
	          fi++;
	          li--;  
	        }
	        
	        
	    }
	    return true;
	}

	

}