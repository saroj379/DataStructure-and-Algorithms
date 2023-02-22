import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));

    }
}

class Solution {
    static int binarySearch(int[] arr, int st, int end){
        int lo = st, hi = end;
        int idxOf1 = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == 0){
                lo = mid + 1;
            }
            else if(arr[mid] == 1){
                idxOf1 = mid;
                hi = mid - 1;
            }
        }
        int ans = arr.length - idxOf1 + 1;
        return ans;
    }

    static int rowWithMaximumOnes(int arr[][], int n, int m) {
        int highest1s = Integer.MIN_VALUE;
        int ans=-1;
        for(int row =0; row < n; row++){
            int start_col = 0, end_col = arr[row].length-1;
            int currMax = binarySearch(arr[row], start_col, end_col);
            // System.out.println("In "+row+" 1's present: "+currMax);
            if(highest1s < currMax) {
                highest1s=currMax;
                ans=row;
            }
        }
        return ans;
    }
}