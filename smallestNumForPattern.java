import java.util.*;

public class smallestNumForPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string having 'd's & 'i's : ");
        String str = sc.nextLine();
        System.out.println("The smallest possible number is : ");
        Stack<Integer> st = new Stack<>();
        int num = 1;// number to be printed

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);// gettting the current char from string

            // if it's d => decrease
            // i.e 1.Push num to stack 2.Inc num by 1
            if (ch == 'd') {
                st.push(num);
                num++;
            }
            // if it's i => increase
            // i.e 1.Push num to stack 2.Inc num by 1 3.pop all elem and print
            else {
                st.push(num);
                num++;

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }

        // one num is still left when we reach last char
        // as for a string having only 1 char there are 2 nums to be printed
        st.push(num);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
}