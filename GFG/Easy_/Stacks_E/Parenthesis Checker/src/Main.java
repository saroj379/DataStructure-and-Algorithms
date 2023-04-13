//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Reading total number of testcases
        int t= sc.nextInt();

        while(t-- >0)
        {
            //reading the string
            String st = sc.next();

            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }
}
// } Driver Code Ends



class Solution
{
    // getting corresponding char
    static char absolutechar(char c){
        if(c == ')') return '(';
        else if(c == '}') return '{';
        else if(c == ']') return '[';
        return 'c';
    }

    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<x.length(); i++){
            char ch = x.charAt(i);
            // if get corresponding char then pop
            if(!st.empty() && st.peek() == absolutechar(ch)) st.pop();
                // else push
            else st.push(ch);
        }

        if(st.empty()) return true;
        return false;
    }
}