//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static String isBalanced(int a[],int n,int x)
    {
        int lo = 0, hi = n-1;
        int pot_left = -1, pot_right = -1;

        if(a[lo] > x || a[hi] < x) return "Balanced";

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == x) return "Balanced";
            else if(a[mid] > x){
                pot_right = a[mid];
                hi = mid -1;
            }
            else{
                pot_left = a[mid];
                lo = mid+1;
            }
        }

        // System.out.println(pot_left +" "+pot_right);
        if(x-pot_left == pot_right-x) return "Balanced";
        return "Not Balanced";
    }
}

//{ Driver Code Starts.

// Driver class
class GFG {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            int x=Integer.parseInt(br.readLine());
            Solution ob=new Solution();
            String ans=ob.isBalanced(a,n,x);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends