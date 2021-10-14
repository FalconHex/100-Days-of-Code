import java.io.*;
import java.util.*;

public class normalQueue {

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size of queue: ");
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter your choice: \n 1)add \n 2)remove \n 3)peek \n 4)size \n 5)display");
        System.out.print("==> ");
        String str = br.readLine();
        System.out.println("---------------------------------------------------------------------");

        
        while(str.equals("quit") == false){
            
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } 
            else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            }
            else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } 
            else if(str.startsWith("size")){
                System.out.println(qu.size());
            } 
            else if(str.startsWith("display")){
                qu.display();
            }
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter your choice: \n 1)add \n 2)remove \n 3)peek \n 4)size \n 5)display");
            System.out.print("==> ");
            str = br.readLine();
            System.out.println("---------------------------------------------------------------------");

        }
    }
    
    public static class CustomQueue {
        int[] data; //array acting as queue
        int front; //pointer at front
        int size; //number of elements in queue

        // param const
        public CustomQueue(int cap) {
            data = new int[cap];
            // initially pointer & size = 0
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for(int i = 0; i < size; i++) {
                // starts from the pint where front was left
                // after reaching end to print left data => go back to start we need to use % 
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " | ");
            }
            System.out.println();
        }

        void add(int val) {
            
            if(size == data.length){
                System.out.println("Queue Overflow!");
            }
            else{
                // we % by length as say we removed 2 elem from front
                // now front is at index 2 and size = 3 {considering queue was full}
                // 2+3 =5 but total index = 0 to 4 => now if we add new elem at index 5 = exception
                // thus we (front + size)%data.length; => 5%5 = 0 => and this is the correct place to add new elem
                int rear = (front + size)%data.length; //found the last available index
                data[rear] = val; //added elem to that index
                size++; //increased size by one
            }
        }

        int remove() {
            if(size == 0){
                System.out.println("Queue Underflow!");
                return -1; 
            }
            else{
                int val = data[front]; //got elem in front to display
                front = (front + 1) % data.length; //increased front to point to next elem => after removing last elem go to first
                size--; //size reduced by 1 as now front elem is not considerd a part
                return val;
            }
        }

        int peek() {
            if(size == 0){
                System.out.println("Queue Underflow!");
                return -1; 
            }
            else{
                return data[front]; // displays elem in front
            }
        }
    }

    
}