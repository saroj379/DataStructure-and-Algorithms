import java.util.*;

class Solution {
    int rangeOfSum(int[] arr, int sp, int ep){
        if(sp == 0) return arr[ep];
        return arr[ep] - arr[sp-1];
    }

    public int[] sumQuery(int[] arr, int[][] ranges) {
        int n = arr.length;
        int q = ranges.length;
        int ans[] = new int[q];

        // Creating new prefixSum array
        for(int i=1; i<n; i++){
            arr[i] += arr[i-1];
        }

        // get the sum in range
        for(int i=0; i<q; i++){
            int sp = ranges[i][0];
            int ep = ranges[i][1];
            ans[i] = rangeOfSum(arr, sp, ep);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}