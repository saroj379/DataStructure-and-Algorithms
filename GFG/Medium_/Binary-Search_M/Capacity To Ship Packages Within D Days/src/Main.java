//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPossibleToShip(int[] arr, int N, int D, int weight){
        int noOfDays = 1;
        int totalWeight = 0;
        for(int e : arr){
            totalWeight += e;
            if(totalWeight > weight) {
                noOfDays ++;
                totalWeight = e;
            }
        }
        return noOfDays <= D;
    }

    static int leastWeightCapacity(int[] arr, int N, int D) {
        int min = 0;
        int max = 0;
        for(int e : arr){
            min = Math.max(e, min);
            max += e;
        }

        int lo = min;
        int hi = max;
        int pAns = 0;
        while(lo <= hi){
            int weight = (lo + hi) / 2;
            if(isPossibleToShip(arr, N, D, weight)){
                pAns = weight;
                hi = weight -1;
            }else lo = weight +1;
        }
        return pAns;
    }
};