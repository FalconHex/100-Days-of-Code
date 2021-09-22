import java.util.*;

public class dateSort {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of dates : ");
        int n = scn.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter the date for : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Index "+ i+" : ");
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        System.out.println("Dates sorted : ");
        print(arr);
    }
    
    public static void sortDates(String[] arr) {
        // parameters passed
        // 1.arr = date
        // 2.div = to remove the unwanted part of dates
        // 3.mod = to get the required part of dates
        // 4.range = to get the lenngth of freq array
        countSort(arr, 1000000, 100, 32); //sorts on basis of days
        countSort(arr, 10000, 100, 13); //sorts on basis of months
        countSort(arr, 1, 10000, 2501); //sorts on basis of years
    }

    public static void countSort(String[] arr,int div, int mod, int range) {
        // write your code here
        
        int[] farr = new int[range]; // freq array => stores freq. of each elem which will be b/w 0 and 9

        // filling farr
        for(int i = 0; i < arr.length; i++) {
            farr[Integer.parseInt(arr[i],10)/ div % mod ]++; //this finds the digit of elem and compares and increase it's freq
        }

        // transforming freq. arr to prefix sum array => freq of prev elem + freq of current elem
        // this tell the last index where the current elem will be stored => if for elem 3 value is 5 = last 3 will be at index 4
        for(int i=1; i<farr.length; i++) {
            farr[i] += farr[i-1];
        }

        String[] ans = new String[arr.length]; //answer array

        // traversing through given array backwards
        for(int i=arr.length-1; i>=0; i--){
            int pos = farr[Integer.parseInt(arr[i],10)/ div % mod] - 1; // pos where the current elem's freq is stored
            ans[pos] = arr[i]; // placing at correct position
            farr[Integer.parseInt(arr[i],10)/ div % mod]--;//decreasing the freq of the placed element
        }

        // filling the og array
        for(int i=0; i<arr.length; i++){
            arr[i] = ans[i]; 
        }
        
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int date = Integer.parseInt(arr[i],10);
            int day = (date/1000000) % 100;
            int month = (date/10000) % 100;
            int year = (date/1) % 10000;
            
            if(day < 10){
                System.out.print("0"+day+"/");
            }
            else{
                System.out.print(day+"/");

            }

            if(month < 10){
                System.out.print("0"+month+"/");
            }
            else{
                System.out.print(month+"/");

            }
            System.out.println(year);
        }
    }

    

}