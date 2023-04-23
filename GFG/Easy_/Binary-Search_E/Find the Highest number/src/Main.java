//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for( int i = 0; i < n; i++)
            {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findPeakElement(List<Integer> a)
    {
        int lo = 0;
        int hi = a.size()-1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            // left part is not present
            if(mid-1 < 0){
                if(a.get(mid) > a.get(mid+1)){
                    return a.get(mid);
                }else lo = mid+1;
            }

            // if right is not present
            else if(mid+1 >= a.size()){
                if(a.get(mid) > a.get(mid-1)){
                    return a.get(mid);
                }else hi = mid-1;
            }

            // the peak present at middle
            else{
                // System.out.println(mid);
                if(a.get(mid) > a.get(mid-1) && a.get(mid) > a.get(mid+1)) return a.get(mid);
                if(a.get(mid) > a.get(mid-1)) lo = mid +1;
                else hi = mid -1;
            }
        }

        return -1;
    }
}