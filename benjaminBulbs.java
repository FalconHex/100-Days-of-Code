import java.util.*;

public class benjaminBulbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bulbs: ");
        int num = sc.nextInt();

        System.out.println("After "+num+" fluctions the bulbs in on position are: ");

        for(int i=1; i*i<=num; i++){
            System.out.println(i*i);
        }
    }
}

// given n bulbs in first fluction all are turned on
// in 2nd fluction every 2nd bulb is turned off
// in 3rd every 3rd bulb is toggled
// it is observed that that a bulb is toggled due to it's factor => 3rd round will toggle all multiples of 3
// perfect square has odd factors thus at last itteration bulb will remain on