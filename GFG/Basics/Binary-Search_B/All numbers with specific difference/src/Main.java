//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long N = Long.parseLong(S[0]);
            Long D = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getCount(N,D));
        }
    }
}
// } Driver Code Ends

//User function Template for Java

class Solution {
    static long sum(long n){
        long sum =0;
        while(n > 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    static long getCount(long N , long D) {
        // code here
        long l =1, h = N;
        while(l <= h){
            long mid = (l + h)/2;
            // if the value is less then go forward
            if(mid - sum(mid) < D) l = mid +1;
                // else go backward
            else h = mid-1;
        }
        // h will reach the last where the value is less then D, so to get the number of element
        return (N-h);
    }
};