import java.util.*;
public class abcSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string of type abc: ");
        String str = scn.next();

        int res = getCount(str);
        System.out.print("Number of subsequence of type a+b+c+ = " + res);
    }

    public static int getCount(String str) {

        int a = 0; // when a is added to string
        int ab = 0; // when b is added to string
        int abc = 0;// when c is added to string

        for(int i=0; i<str.length(); i++) {            
            char ch = str.charAt(i);

            if(ch == 'a'){
                
                //when new "a" comes there are 3 situations
                // 1. new a adds after exsisting a
                // 2. new a does not add
                // 3. new a forms it's own subseq
                // thus (point 1 + point 2) = 2a and (point 3) => +1
                a = (2*a) + 1;
            }
            else if(ch == 'b'){
                
                // when new "b" comes there are 3 situations
                // 1. new b adds after exsisting ab
                // 2. new b does not add
                // 3. new b adds after all subseq of a+
                // thus (point 1 + point 2) = 2ab and (point 3) => +(no. of subseq of a)
                ab = (2*ab) + a;
            }
            else if(ch == 'c'){
                
                // when new "c" comes there are 3 situations
                // 1. new c adds after exsisting abc
                // 2. new c does not add
                // 3. new c adds after all subseq of ab+
                // thus (point 1 + point 2) = 2abc and (point 3) => +(no. of subseq of ab)
                abc = (2*abc) + ab;
            }
        }
        return abc;
    }
    
    
}
