import java.util.*; 
public class exitPointMatrix {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns : ");
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        System.out.println("Enter elements of matrix : ");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print("For index ("+i+","+j+") : ");
                arr[i][j] = scn.nextInt();
            }
        }

        findExit(arr);
    }

    public static void findExit(int[][] arr){
        // var to know direction
        int dir = 0;
        int i = 0;
        int j = 0;
        while(true){
            // there are only 4 directs => factor of 4
            // direction will only increment if we get 1 in path
            dir = (dir + arr[i][j]) % 4;            
            if(dir == 0){ //east => column++
                j++;
            } else if(dir == 1){ //south => row++
                i++;
            } else if(dir == 2){ //west => column --
                j--;
            } else if(dir == 3){ //north => row--
                i--;
            }
            // exit points
            // we only come to know after we have exited so
            if(i < 0){
                i++; // exit is from left wall so i= -ve => increment by 1
                break;
            } else if(j < 0){
                j++; // exit is from top wall so i= -ve => increment by 1
                break;
            } else if(i == arr.length){
                i--; // exit is from right wall so i> arr.length => decrement by 1
                break;
            } else if(j == arr[0].length){
                j--;// exit is from bottom wall so i> arr[0].length => decrement by 1
                break;
            }
        }

        System.out.println("Exited from: ");
        System.out.println("Row = "+ i);
        System.out.println("Coulumn = " +j);
    }
}
