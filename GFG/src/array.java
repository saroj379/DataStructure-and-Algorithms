/*
Arrays
*/

import java.util.Arrays;

class array {
    //Binnary Search
    int binarysearch(int arr[], int n, int k) {
        int i=0; int j = n-1;
        while(i <= j){
            int mid = (i+j)/2;
            // System.out.println(mid+" "+i+" "+j);
            if(arr[mid] > k){
                j= mid-1;
            }
            else if(arr[mid] < k){
                i = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    //2nd Largest Elements in array
    int print2largest(int arr[], int n) {
        // code here
        int max = Integer.MIN_VALUE, sec_max= Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        for(int i=0; i<n; i++){
            if(max != arr[i] && sec_max < arr[i]){
                sec_max = arr[i];
            }
        }
        if(sec_max == Integer.MIN_VALUE){
            return -1;
        }
        return sec_max;
    }

    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<n; i++){
            if(A[i]!=B[i]){
                return false;
            }
        }
        return true;
    }
}