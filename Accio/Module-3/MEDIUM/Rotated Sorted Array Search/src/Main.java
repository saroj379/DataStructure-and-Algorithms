import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A,B));

    }
}

class Solution{
    public int search(final int[] a, int target) {
        int low = 0, hi = a.length-1;
        while(low <= hi){
            int mid = (low + hi) / 2;
            if(a[mid] == target) return mid;
            // if the 1st half is sorted
            if(a[mid] >= a[low]){
                if(target >= a[low] && target <= a[mid]) hi = mid -1;
                else low = mid+1;
            }

            // 2nd half
            else{
                if(target >= a[mid] && target <= a[hi]) low = mid + 1;
                else hi = mid -1;
            }
        }
        return -1;
    }
}