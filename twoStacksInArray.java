import java.io.*;
import java.util.*;

public class twoStacksInArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter combined size of 2 stacks: ");
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);
    
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter your choice: \n 1)push1  \n 2)push2 \n 3)pop1 \n 4)pop2 \n 5)top1 \n 6)top2 \n 7)size1 \n 8)size2");
        System.out.print("==> ");
        String str = br.readLine();
        System.out.println("---------------------------------------------------------------------");

        while (str.equals("quit") == false) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            }
            else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            }
            else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            }
            else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter your choice: \n 1)push1  \n 2)push2 \n 3)pop1 \n 4)pop2 \n 5)top1 \n 6)top2 \n 7)size1 \n 8)size2");
            System.out.print("==> ");
            str = br.readLine();
            System.out.println("---------------------------------------------------------------------");
        }
    }

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");

            }
            else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } 
            else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;

            } 
            else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } 
            else {
                int val = data[tos1];
                return val;
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }     
            else {
                int val = data[tos2];
                return val;
            }
        }
    }
}