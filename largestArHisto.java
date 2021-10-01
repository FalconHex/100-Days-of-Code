import java.util.*;
public class largestArHisto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Enter element at : ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Element "+i+ " : ");
            arr[i] = sc.nextInt();
        }

        area(arr);
    }

    public static void area(int[]arr) {

        // right boundary => next smaller element to right
        int[] rb = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);//pushing index of last elem of array
        rb[arr.length-1] = arr.length; //no element to right so = size of array+1
        for(int i=arr.length-2; i>=0; i--){

            // if elem in stack is greater than cureent elem = pop
            while(st.size() > 0 && arr[i] < arr[st.peek()] ){
                st.pop();
            }

            if(st.size() == 0){
                rb[i] = arr.length;
            }
            else{
                rb[i] = st.peek();
            }

            st.push(i); //pushing index of current elem
            
        }

        // left boundary => next smaller element to left
        int[] lb = new int[arr.length];
        st = new Stack<>();
        st.push(0);//pushing index of first elem of array
        lb[0] = -1;//no element to left so = -1
        for(int i=1; i < arr.length; i++){

            // if elem in stack is greater than cureent elem = pop
            while(st.size() > 0 && arr[i] < arr[st.peek()] ){
                st.pop();
            }

            if(st.size() == 0){
                lb[i] = -1;
            }
            else{
                lb[i] = st.peek();
            }
            st.push(i); //pushing index of current elem
            
        }

        // max area 
        int maxArea = 0;
        for(int i=0; i<arr.length; i++){
            int width = (rb[i] - lb[i])-1; //default cases help us as when we subtrct them it gives size of array
            int height = arr[i];
            int area = width*height;

            if(area > maxArea){
                maxArea = area;
            }
        }

        System.out.println("Max area in histogram for given values = "+ maxArea);

    }
}
