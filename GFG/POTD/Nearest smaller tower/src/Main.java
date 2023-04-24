//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int[n];
            String [] str = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            Solution ob = new Solution();
            int [] ans = ob.nearestSmallestTower(arr);
            for(int i = 0; i < n; i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }

    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    // prev smaller  index
    int[] prevSmallerIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i =0; i<arr.length; i++){

            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()) ans[i] = st.peek();
            else ans[i] = -1;
            st.push(i);
        }

        return ans;
    }
    // get next smaller indexes
    int[] nextSmallerIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i =arr.length-1; i>=0; i--){

            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()) ans[i] = st.peek();
            else ans[i] = -1;
            st.push(i);
        }

        return ans;
    }

    int [] nearestSmallestTower(int [] arr){
        int[] left = prevSmallerIndex(arr);
        int[] right = nextSmallerIndex(arr);

        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){

            // check wherethere both has -1 mean no smaller
            if(left[i] == right[i]) ans[i] = -1;

                // if no smaller on left
            else if(left[i] == -1) ans[i] = right[i];

                // if no smaller on right
            else if(right[i] == -1) ans[i] = left[i];

                // if both are at same distance
            else if(Math.abs(i-left[i]) == Math.abs(right[i]-i)){
                // put who is close to it
                if(arr[left[i]] <= arr[right[i]]) ans[i] = left[i];
                else ans[i] = right[i];
            }

            // check where the elements are close to it mean less dist
            else{
                if(Math.abs(i-left[i]) < Math.abs(right[i]-i)) ans[i] = left[i];
                else ans[i] = right[i];
            }
        }

        return ans;
    }
}