import java.util.*;
public class celebProblem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of members : ");
        int n = sc.nextInt();

        int[][] members = new int[n][n];

        System.out.println("If member 'A' know member 'B' give input as : 1 else : 2");
        for(int i = 0; i < members.length; i++) {
            for(int j = 0; j < members[0].length; j++) {
                System.out.print("Does member " + i + " knows memeber " +j+ " : " );
                members[i][j] = sc.nextInt();
            }
        }

        findCeleb(members);
        // A celeb is described as a member who knows no one but everyone elese knows them
        // arr[i][j] => wether i knows j or not

        // x | 0  | 1 | 2 | 3 |
        // --------------------
        // 0 | 0  | 0 | 1 | 1 |
        // --------------------
        // 1 | 0  | 1 | 1 | 0 |
        // --------------------
        // 2 | 0  | 0 | 0 | 0 | ==> celeb
        // --------------------
        // 3 | 0  | 0 | 1 | 0 |
    }

    public static void findCeleb(int[][] members) {

        // A stack to store all the members
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<members.length; i++) {
            st.push(i);
        }
        while(st.size() >= 2 ){
            int i = st.pop();
            int j = st.pop();
            // if i know j => i can't be celeb
            if(members[i][j] == 1 ){
                st.push(j);
            }
            // if i does not know j => j can't be celeb
            else{
                st.push(i);
            }
        }
        int pot = st.pop(); //potential celeb
        for(int i=0; i<members.length; i++){
            // as we don't need to check if i knows itself => avoid diagonal
            if(i != pot ){
                // if any memeber "i" doesn't know pot celeb(check all rows,pot celeb column ) || 
                // if pot celeb knows anyone (check pot celeb row, all columns)
                if(members[i][pot] == 0 || members[pot][i] == 1 ){
                    System.out.println("No celebrity exsists!");
                    return;
                }
            }
        }

        System.out.println("Member " + pot+ " is a celebrity!");
    }

}