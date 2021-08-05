import java.util.*;

public class subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        dispSub(arr);
    }

    public static void dispSub(int[] arr){

        // getting the length of array 
        // to know how many place to assign in each subset
        int len = arr.length;

        // tot. no. of subset = 2^n
        int tot = (int)Math.pow(2,len);

        // running a loop to check for each subset
        for(int k=0; k<tot; k++) {

            // stores wether a elem will participate in being in subset or not
            int[]bin = decToBin(k,len);

            // running through bin array
            for(int i=0; i<len; i++){
                
                // if it has 0 thus elem of arr in that index won't participate in subset
                if(bin[i] == 0){
                    System.out.print("-\t");
                }
                else{
                    System.out.print(arr[i]+"\t");
                }
            }
            System.out.println();
        }
    }

    
    public static int[] decToBin(int k, int len){

        // array to return
        int[] arr = new int[len];
        // var bcoz we need to fill the above array in rev order
        int idx = len-1;

        // finding binary equivalent to the current index
        while(k>0){
            int dig = k%2;
            k = k/2;

            arr[idx] = dig;
            idx--;
        }
        return arr;
    }
}

// subset and binary have pattern in common
// tot no. of subsets = 2^n
// say for elements 123=> tot subsets = 2^3 = 8
// idx      binary equivalent to idx         subsets 
//   0           000                        -	-	-	
//   1           001                        -	-	3	
//   2           010                        -	2	-	
//   3           011                        -	2	3	
//   4           100                        1	-	-	
//   5           101                        1	-	3	
//   6           110                        1	2	-	
//   7           111                        1	2	3	
