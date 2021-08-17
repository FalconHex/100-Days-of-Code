import java.util.*;

public class spiralArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        
        int [][] arr = new int[m][n];    
        System.out.println("Enter elements: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
    int minr = 0;
    int minc = 0;
    
    int maxr = arr.length -1;
    int maxc = arr[0].length -1;
    int tno  = m*n;
    int cnt = 0;
    
    while(cnt<tno){
    
    //left
    for(int i=minr , j=minc; i<=maxr && cnt<tno; i++){
        System.out.println(arr[i][j]);
        cnt++;
    }minc++;
    
    //bottom
    for(int i=maxr , j=minc; j<=maxc && cnt<tno; j++){
        System.out.println(arr[i][j]);
        cnt++;
    }maxr--;
    
    //right
    for(int i=maxr , j=maxc; i>=minr && cnt<tno; i--){
        System.out.println(arr[i][j]);
        cnt++;
    }maxc--;
    
    //top
    for(int i=minr , j=maxc; j>=minc && cnt<tno; j--){
        System.out.println(arr[i][j]);
        cnt++;
    }minr++;
}
}

}