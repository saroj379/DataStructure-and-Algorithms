//{ Driver Code Starts
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(a,n));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    // left smaller element
    int[] leftSmallerElement(int[] a){
        int[] ans = new int[a.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<a.length;i++){
            while(!st.empty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(st.empty()) ans[i] =0;
            else {
                ans[i] = a[st.peek()];
            }
            st.push(i);
        }

        return ans;
    }

    // right smaller element
    int[] rightSmallerElement(int[] a){
        int[] ans = new int[a.length];
        Stack<Integer> st = new Stack<>();
        for(int i=a.length-1;i>=0; i--){
            while(!st.empty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(st.empty()) ans[i] =0;
            else {
                ans[i] = a[st.peek()];
            }
            st.push(i);
        }

        return ans;
    }

    int findMaxDiff(int a[], int n)
    {
        int[] ls = leftSmallerElement(a);

        int[] rs = rightSmallerElement(a);

        int maxDist = 0;
        for(int i=0; i<n; i++){
            int currDiff = Math.abs(ls[i]-rs[i]);
            maxDist = Math.max(currDiff, maxDist);
        }

        return maxDist;
    }
}