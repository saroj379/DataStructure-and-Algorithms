//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int [] A = new int[N];
            String [] str = br.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(str[i]);
            Solution ob = new Solution();
            System.out.println(ob.equalSum(A, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // Approach-1
    int equalSum(int [] A, int N) {
        int rsum = 0;
        for(int i=0; i<N; i++){
            rsum += A[i];
        }

        int lsum =0;
        for(int i=0; i<N; i++){
            // subtracting to compare with lsum that same or not
            rsum -= A[i];
            // if same return that index else add that element to lsum
            if(lsum == rsum){
                return i+1;
            }
            else{
                lsum += A[i];
            }
        }
        // if will not get such things
        return -1;
    }

    
    // Approach-2 (Prefix-Sum)
    int equalSum_(int [] A, int N) {
        int[]ans = new int[N];
        ans[0] = A[0];
        for(int i =1; i <N; i++){
            ans[i] = ans[i-1] + A[i];
        }

        if(N==1) return 1;

        for(int i=1; i<N; i++){
            if(ans[i-1] + ans[i] == ans[N-1]){
                return i+1;
            }
        }

        return -1;
    }
}