//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static List<Integer> pattern(int N){
        // code here
        List<Integer> l = new ArrayList<>();
        return printPattern(N, N, true, l);
    }
    static List<Integer> printPattern(int N, int start, boolean inc, List<Integer> l){

        l.add(start);

        if(N == start && inc == false) return l;

        if(inc){

            if(start-5 > 0){
                return printPattern(N, start-5, true, l);
            }
            else{
                return printPattern(N, start-5, false, l);
            }

        }
        else{

            return printPattern(N, start+5, false, l);
        }
    }
}