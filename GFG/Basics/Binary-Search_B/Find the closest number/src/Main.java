//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        while(testcases-- > 0){

            String line1 = br.readLine();
            String []element = line1.trim().split(" ");
            int n = Integer.parseInt(element[0]);
            int target = Integer.parseInt(element[1]);

            int arr[] = new int[n];


            String line = br.readLine();
            String[] elements = line.trim().split(" ");

            for(int index = 0;index < n; index++){
                arr[index] = Integer.parseInt(elements[index]);
            }

            Solution obj = new Solution();

            System.out.println(obj.findClosest(arr, n, target));

        }

    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{

    public static int findClosest(int arr[], int n, int target)
    {

        int lo = 0, hi = n-1, pot_left = -1, pot_right= -1;
        // if the target is less then 0th ele 
        if(arr[lo] > target) return arr[lo];
        // if last is smaller than target
        if(arr[hi] < target) return arr[hi];

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) return arr[mid];// if array has same value as target then it is vry close to it
                // if mid ele is greater then move hi to mid-1
            else if(arr[mid] > target){
                pot_right = arr[mid];
                hi = mid-1;
            }
            // else move hi to right
            else{
                pot_left = arr[mid];
                lo = mid+1;
            }
        }
        // check who is smaller the left or right
        int leftDiff = target - pot_left;
        int rightDiff = pot_right - target;
        if(leftDiff < rightDiff) return pot_left;

        return pot_right;
    }
}

