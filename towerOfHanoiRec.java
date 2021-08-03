import java.util.*;

public class towerOfHanoiRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //num of disks
        int t1 = sc.nextInt(); //id for src tower
        int t2 = sc.nextInt(); //id for dest tower
        int t3 = sc.nextInt(); //id for helper tower

        toh(n, t1, t2, t3);
    }

    public static void toh(int n, int t1, int t2, int t3){

        // base case: when no disks left in tower
        if(n==0) return;

        //faith:  shifting (n-1) disks from t1 to t3
        toh(n-1,t1,t3,t2);
        // my work: shifting (n)th disk from t1 to t2
        System.out.println(n+" [ "+t1+" => "+t2+" ]");
        // faith: shifting (n-1) disks from t3 to t2
        toh(n-1,t3,t2,t1);

    }
}

// Basic steps involved for say n=3 and tower ids: 10,11 and 12 respectively
// Aim: move all 3 disks from t1 to t2
// Rules: (a) move 1 disk at a time (b)bigger disk can't be above smaller ones
// Procedure
// (1): move disk 1 from t1 to t2 
// (2): move disk 2 from t1 to t3
// (3): move disk 1 from t2 to t3
// (4): move disk 3 from t1 to t2
// (5): move disk 1 from t3 to t1
// (6): move disk 2 from t3 to t2
// (7): move disk 1 from t1 to t2