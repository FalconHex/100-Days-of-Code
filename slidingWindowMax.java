import java.util.*;
public class slidingWindowMax{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter element at : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Index "+ i+ " : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter size of window : ");
        int k = sc.nextInt();

        findMax(arr, k);
    }

    public static void findMax(int[]arr, int k) {
        
        // --------Next greater element to right starts--------
        Stack<Integer> st = new Stack<>();
        int[]nge = new int[arr.length];

        // pushing index of last elem of array into stack
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length; // as there is no nge of last elem

        for(int i=arr.length-2; i>=0; i--){
            // keep poping if current elem of array > top elem of stack
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }

            // if stack is empty
            if(st.size() == 0){
                nge[i] = arr.length;
            }
            else{
                nge[i] = st.peek();
            }

            // pushing the index of current elem into Stack
            st.push(i);
        }
        // --------Next greater element to right ends--------

        int j=0; //var to keep check of size of window

        // i moves to each index marking start of every new window
        for(int i=0; i<= arr.length-k; i++){
            
            // if j is left behind make it equal to i
            if(j<i){
                j=i;
            }
            // if index of nge to i is inside the window keep jumping to nge
            while(nge[j] < i+k ){
                j = nge[j];
            }

            // System.out.println(arr[j]);
            int res = arr[j];
            display(arr, i, k, res);
        }   
    }

    public static void display(int[]arr, int idx, int k, int res) {
        System.out.println("Max element in the window with elements : ");
        for(int i = idx; i < idx+k; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println("=> "+ res);
    }
}