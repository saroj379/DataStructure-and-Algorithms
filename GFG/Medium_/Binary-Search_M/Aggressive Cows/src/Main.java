//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean isPossibleToPlace(int n, int k, int[] stalls, int capDist){
        int lastPositionOfCow = 0;
        int noOfCows = 1;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i] -stalls[lastPositionOfCow] >= capDist){
                lastPositionOfCow = i;
                noOfCows ++;
            }
        }

        return noOfCows >= k;
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int min = 1;
        int max = 0;
        for(int dist : stalls){
            max =  Math.max(max, dist);
        }

        int lo = min;
        int hi = max;
        int pAns =0;

        // System.out.println(lo+" -- "+hi);
        while(lo <= hi){
            int dist = (lo + hi) /2;

            if(isPossibleToPlace(n, k, stalls, dist)){
                // System.out.println(pAns);
                pAns = dist;
                lo = dist +1;
            }else{
                // System.out.println(lo+" -- "+hi);
                hi = dist -1;
            }
        }

        return pAns;
    }
}