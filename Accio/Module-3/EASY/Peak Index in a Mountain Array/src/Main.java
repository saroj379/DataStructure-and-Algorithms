import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            // if my left is not available
            if(mid-1 < 0){
                if (A[mid] > A[mid+1]){
                    return mid;
                }
                else hi = mid -1;
            }
            // if my right part is not there
            else if(mid +1 >= A.length){
                if(A[mid] > A[mid-1]){
                    return mid;
                }else lo = mid + 1;
            }

            else{
                if(A[mid] > A[mid+1] && A[mid] > A[mid - 1]){
                    return mid;
                }
                else if(A[mid] > A[mid -1]){
                    lo = mid + 1;
                }else hi = mid -1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}