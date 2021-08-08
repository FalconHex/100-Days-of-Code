import java.util.*;
public class stairsRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        ArrayList<String> res = getStairs(n);
        System.out.println("Possible paths to reach bottom are :");
        System.out.println(res);
    }

    public static ArrayList<String> getStairs(int n) {
        // base case: when you are at level 0
        // ways to reach level 0 itself = 1 => don't move
        if(n == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        // -ve base case => if somehow you are below level 0
        // there is no way to come up
        if(n<0){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }        
        // all the paths to reach level 0 from level n-1
        ArrayList<String> nm1to0 = getStairs(n-1);
        // all the paths to reach level 0 from level n-2
        ArrayList<String> nm2to0 = getStairs(n-2);
        // all the paths to reach level 0 from level n-3
        ArrayList<String> nm3to0 = getStairs(n-3);
        // final result => to reach 0 from n
        ArrayList<String> nto0 = new ArrayList<>();
        // as to reach n-1 from n there can only be 1 way => jump of 1
        // this adding 1 before all the way to reach 0 from n-1 to make it as
        // ways to reach level 0 from n via n-1
        for(int i = 0; i < nm1to0.size(); i++) {
            nto0.add('1' + nm1to0.get(i));
        }
        // as to reach n-2 from n there are be 2 ways => jump of 2 or (jump of 1)x2
        // this adding 2 before all the way to reach 0 from n-2 to make it as
        // ways to reach level 0 from n via n-2
        for(int i = 0; i < nm2to0.size(); i++) {
            nto0.add('2' + nm2to0.get(i));
        }
        // as to reach n-3 from n there are be 3 ways => jump of 2 + jump of 1  or (jump of 1)x3 or jump of 3
        // this adding 3 before all the way to reach 0 from n-3 to make it as
        // ways to reach level 0 from n via n-3
        for(int i = 0; i < nm3to0.size(); i++) {
            nto0.add('3' + nm3to0.get(i));
        }
        return nto0;

    }
}
