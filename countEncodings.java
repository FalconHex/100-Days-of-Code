import java.util.*;
public class countEncodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of numbers not starting with 0: ");
        String str = sc.next();

        int res = getCount(str);
        System.out.println("Number of possible encodings for given string = " + res);
    }

    public static int getCount(String str) {
        
        int[]dp = new int[str.length()];// making a storage of length  = str

        dp[0] = 1;// solving base case that is for 1st char => always = 1

        for(int i = 1; i < dp.length; i++) {
            // if last 2 chars are 0 => we get 0 encoding for this
            if(str.charAt(i-1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0; 
            }
            // if 2nd last char is 0 and last char a non 0 => we only consider adding 2nd last char
            else if(str.charAt(i-1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i-1];
            }
            // if 2nd last char is non 0 and last char is 0 => we can only considering adding both if it's 10 or 20
            else if(str.charAt(i-1) != '0' && str.charAt(i) == '0'){
                // for this to add 2nd last char must either be 1 or 2
                if(str.charAt(i-1) == 1 || str.charAt(i) == 2){
                    // if it's true and we are at index 2 or more add both chars
                    dp[i] = (i >= 2 ? dp[i-2] : 1);
                }
                else{
                    dp[i] = 0;
                }
            }
            else{
                // for all rest if both char is less than or equal 26
                if(Integer.parseInt(str.substring(i-1, i+1)) <= 26 ){
                    dp[i] = dp[i-1] + (i >=2 ? dp[i-2] : 1);
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }

        return dp[str.length()-1];
    }
}
