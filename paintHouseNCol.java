import java.util.*;
public class paintHouseNCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of houses: ");
        int h = sc.nextInt();

        System.out.print("Enter number of colours: ");
        int c = sc.nextInt();

        int[][] costs = new int[h][c];

        System.out.println("Enter cost of colours: ");
        for(int i = 0; i < costs.length; i++) {
            System.out.println("Enter costs for colouring house "+ i + " with colour : ");
            for(int j = 0; j < costs[0].length; j++) {
                System.out.print(j + " : ");
                costs[i][j] = sc.nextInt();
            }
        }

        long res = findMin(costs);
        System.out.println("Min cost of painting "+ h + " houses with no 2 adjacent houses having same colour = "+ res);
    }

    public static long findMin(int[][] costs) {
        int h = costs.length; // rows = house
        int c = costs[0].length; // column = colours
        // 2d array to store cost of colouring house "h" with colour "c"
        long[][] dp = new long[h][c];
        // storing costs of colouring first house with each color
        for(int j=0; j<c; j++){
            dp[0][j] = costs[0][j];
        }
        for(int i= 1; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                Long min = Long.MAX_VALUE;
                // finding the colour of prev house which incurs min cost
                for(int k=0; k<dp[0].length; k++){
                    // making sure no adjacent house have same colours
                    if(k != j){
                        if(dp[i-1][k] < min ){
                            min = dp[i-1][k];
                        }
                    }
                }
                dp[i][j] = costs[i][j] + min;// getting total cost after colouring current house
            }
        }
        Long min = Long.MAX_VALUE;
        // finding min tot cost => in last house(row)
        for(int k=0; k<dp[0].length; k++){
            
            if(dp[h-1][k] < min ){
                min = dp[h-1][k];
            }            
        }
        return min;


    }
}
