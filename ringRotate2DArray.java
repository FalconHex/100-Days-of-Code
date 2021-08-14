import java.util.*;
public class ringRotate2DArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        int[][]arr = new int[r][c];
        
        System.out.println("Enter elememts of matrix: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print("for index ("+i+","+j+") : ");
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Enter shell number to rotate: ");
        int shell = sc.nextInt();

        System.out.print("Enter how much to rotate: ");
        int rot = sc.nextInt();
        
        // func to rotate the given shell
        rotateShell(arr, shell, rot);
        
        System.out.println("Given Matrix: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix after rotating "+shell+" shell "+rot+" times :");
        // func to display 2D array after rotation
        display(arr);
    }

    
    // function to rotate given shell
    public static void rotateShell(int[][]arr, int shell, int rot){
        // func to fill oneD array using the elem of given shell
        int[]oneD = fillOneDFromShell(arr,shell);
        // func to perform rotation
        rotate(oneD, rot);
        // func to fill shell using elem of oneD array
        fillShellFromOneD(arr, shell, oneD);
        
    }   
    //Step 1:  function to take givenn shell out inside a oneD array
    public static int[] fillOneDFromShell(int[][]arr, int shell){
        
        int minr = shell-1;
        int minc = shell-1;
        int maxr = arr.length-shell;
        int maxc = arr[0].length-shell;
        
        //{ ----CALCULATION FOR SIZE----
        // size = elem of (lw + bw + rw + tw) - 4; 
        // -4 as corners would be repeated
        
        // lw = maxr-minr + 1;
        // bw = maxc-minc + 1;
        // rw = maxr-minr + 1;
        // tw = maxc-minc + 1;
        
        // thus size = 2*(lw + bw) -4
        //  = 2*(maxr-minr + 1 + maxc-minc + 1) -4
        //  = 2maxr - 2minr + 2 + 2maxc - 2minc + 2 -4
        //  = 2maxr - 2minr + 2maxc - 2minc
        //  = 2(maxr - minr + maxc - minc)}
        
        int size = 2*(maxr - minr + maxc - minc);
        int[]oneD = new int[size];
        int idx = 0;

        // lw
        for(int i=minr, j=minc; i<=maxr; i++){
            oneD[idx] = arr[i][j];
            idx++;
        }  
        // bw
        for(int i=maxr, j=minc+1; j<=maxc; j++){
            oneD[idx] = arr[i][j];
            idx++;
        }
        // rw
        for(int i=maxr-1, j=maxc; i>=minr; i--){
            oneD[idx] = arr[i][j];
            idx++;
        }
        // tw
        for(int i=minr , j=maxc-1; j>=minc+1; j--){
            oneD[idx] = arr[i][j];
            idx++;
        }
        
        return oneD;
    }
    //Step 2: function to rotate the oneD array
    public static void rotate (int[]oneD, int rot){
        
        // if rot was bigger than size of arr
        rot = rot%oneD.length;
        // if rot was -ve
        if(rot < 0){
            rot = rot+oneD.length;
        }
        // reversing 1st part of arr
        reverse(oneD,0,oneD.length-rot-1);
        // reversing 2nd part of arr
        reverse(oneD,oneD.length-rot,oneD.length-1);
        // reversing full arr
        reverse(oneD,0,oneD.length-1);
    } 
    //Sub-Step 2: revrse function used in rotation
    public static void reverse(int[]oneD, int li, int ri){
        
        while(li < ri){
            int temp = oneD[li];
            oneD[li] = oneD[ri];
            oneD[ri] = temp;     
            li++;
            ri--;
        }
    }
    //Step 3: function to fill the shell after rotation
    public static void fillShellFromOneD(int[][]arr, int shell, int[]oneD){
        
        int minr = shell-1;
        int minc = shell-1;
        int maxr = arr.length-shell;
        int maxc = arr[0].length-shell;
        
        int idx = 0;
        
        // lw
        for(int i=minr, j=minc; i<=maxr; i++){
            arr[i][j] = oneD[idx];
            idx++;
        }
        
        // bw
        for(int i=maxr, j=minc+1; j<=maxc; j++){
            arr[i][j] = oneD[idx];
            idx++;
        }
        
        // rw
        for(int i=maxr-1, j=maxc; i>=minr; i--){
            arr[i][j] = oneD[idx];
            idx++;
        }
        
        // tw
        for(int i=minr , j=maxc-1; j>=minc+1; j--){
            arr[i][j] = oneD[idx];
            idx++;
        }
        
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}