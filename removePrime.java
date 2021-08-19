import java.util.*;

public class removePrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        System.out.print("Enter total number of elements: ");
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		System.out.println("Enter elements: ");
        for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println("After removing all primes: ");
        System.out.println(al);
	}
    
    public static void solution(ArrayList<Integer> al){
		// we traverse arraylist from back so that 
        // removal of any index doesn't effect left elements
        for(int i = al.size()-1; i>=0; i--){
		    int val = al.get(i);
		    
		    if(isPrime(val) == true){
		        al.remove(i);
		    }
		}
		
	}
	
	public static boolean isPrime(int val){
	    for(int i=2; i*i<=val; i++){
	        if(val%i == 0){
	            return false;
	        }
	    }
	    return true;
	}
	
	

}