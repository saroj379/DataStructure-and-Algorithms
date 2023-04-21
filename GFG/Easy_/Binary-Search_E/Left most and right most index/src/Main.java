//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

class GFG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);

        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
*/

class Solution {
    long firstOccurance(long v[], long x){
        int lo =0, hi = v.length-1;
        long potential_left = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(v[mid] == x){
                potential_left = mid;
                hi = mid -1;
            }
            else if(v[mid] > x) hi = mid-1;
            else lo = mid+1;
        }

        return potential_left;
    }

    long lastOccurance(long v[], long x){
        int lo =0, hi = v.length-1;
        long potential_right = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(v[mid] == x){
                potential_right = mid;
                lo = mid +1;
            }
            else if(v[mid] > x) hi = mid-1;
            else lo = mid+1;
        }

        return potential_right;
    }

    public pair indexes(long v[], long x)
    {
        long first = firstOccurance(v, x);
        long last = lastOccurance(v, x);
        pair p = new pair(first, last);
        return p;
    }
}