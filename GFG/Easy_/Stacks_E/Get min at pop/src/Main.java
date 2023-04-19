//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class getMin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Taking all the testcases
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //Taking total number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            //adding all the elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            //calling _push method of class GetMin
            //and storing the result in a new Stack
            Stack<Integer>mys = new GetMin()._push(arr,n);

            //calling _getMinAtPop method of class GetMin
            new GetMin()._getMinAtPop(mys);
            System.out.println();
        }
    }
}
// } Driver Code Ends

//User function Template for Java

class GetMin
{
    //Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[],int n)
    {
        Stack<Integer> st = new Stack<>();
        int min =0;
        st.push(arr[0]);
        for(int i=1; i<n; i++){
            st.push(Math.min(st.peek(), arr[i]));
        }
        return st;
    }

    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {
        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }
    }
}