import java.util.*;
public class mergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of intervals : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        System.out.println("Enter the intervals : ");
        for(int i = 0; i < n; i++) {
            System.out.print("Enter start time for interval " + i + " : ");
            arr[i][0] = sc.nextInt();
            System.out.print("Enter end time for interval " + i + " : ");
            arr[i][1] = sc.nextInt();
            System.out.println();

        }

        merge(arr);
    }

    public static void merge(int[][] arr) {
        // an array of the Pair class we created
        Pair[] pairs  = new Pair[arr.length];        
        for(int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        // sorting the pairs
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for(int i=0; i < pairs.length; i++) {
            // if it's first elem simply push
            if(i==0){
                st.push(pairs[i]);
            }
            else{
                Pair top = st.peek();
                // if start time of next interval > end time of interval in stack => push
                if(pairs[i].st > top.et){
                    st.push(pairs[i]);
                }
                // otherwise update et of the interval at top of stack
                else{
                    // et will be updated by greater et of either 
                    // 1. interval in stack or 2. next interval
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }
    // displaying
        {
            Stack<Pair> res = new Stack<>(); //stack to print intervals in ascending order
            while(st.size() > 0){
                res.push(st.pop());
            }

            // displaying the intervals in ascending order
            System.out.println("The merged intervals are : ");
            while(res.size() > 0){
                Pair p = res.pop();
                System.out.println(p.st + " to " + p.et);
            }
        }
        
    }
    // a class to store start and end time of intervals and compare the start times of each
    public static class Pair implements Comparable<Pair>{
        int st; //start time
        int et; //end time 

        // paramitrized constructor
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        // func to compare the sts
        // returns 0 if equal 
        // returns +ve if this > other 
        // returns -ve if this < other
        public int compareTo(Pair other){
            // sort on basis of start time
            if(this.st != other.st){
                return this.st - other.st;
            }
            // if starts are same sort on basis of end time
            else{
                return this.et - other.et;
            }
        }
    }
}
