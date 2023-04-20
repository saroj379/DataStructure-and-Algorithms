//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(read.readLine());
            int l = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.minDaysToEmpty(c, l));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static long minDaysToEmpty(long C, long l) {
        // code here
        long i=1, count = 0;;
        long cap = C;
        while(cap > 0){
            cap = cap + l;
            if(cap > C){
                cap = C;
            }
            cap = cap - i;
            i++;
            count++;
        }

        return count;
    }
}