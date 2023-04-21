//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        while(low <= high){
            int mid = (low + high) / 2;
            // if check mid-1 is present or not && mid value os lesser than mid-1 return mid
            if(mid-1 >= 0 && arr[mid] < arr[mid-1]) return arr[mid];
                // else for mid+1, check mid is greater than mid+1 return mid+1 ele
            else if(mid+1 < arr.length && arr[mid] > arr[mid+1]) return arr[mid+1];
                // if mid is less then equal high then go left
            else if(arr[mid] <= arr[high]) high = mid-1;
                // else go right
            else low = mid+1;
        }
        return arr[low];
    }
}