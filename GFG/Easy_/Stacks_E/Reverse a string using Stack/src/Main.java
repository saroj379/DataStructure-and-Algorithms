//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
    }
}

// } Driver Code Ends


class Solution {

    public String reverse(String S){
        Stack<Character> st = new Stack<>();
        // push each elements to stack
        for(int i=0; i<S.length(); i++){
            st.push(S.charAt(i));
        }

        // make new string and return the newly created string
        String ans = "";
        while(!st.empty()){
            ans += st.pop();
        }

        return ans;
    }
}