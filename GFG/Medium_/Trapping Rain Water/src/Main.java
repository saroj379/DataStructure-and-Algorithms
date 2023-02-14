//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}


// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.


    // next greater element
    static int[] rightMax(int[] arr, int n){
        int[] post = new int[n];
        post[n-1] = arr[n-1];
        for(int i = n-2; i >=0; i--){
            post[i] = Math.max(post[i+1], arr[i]);
        }
        return post;
    }

    // prev greater element
    static int[] leftMax(int[] arr, int n){
        int[] pre = new int[n];
        pre[0] = arr[0];
        for(int i =1; i < n; i++){
            pre[i] = Math.max(pre[i-1], arr[i]);
        }
        return pre;
    }


    static long trappingWater(int arr[], int n) {
        // Your code here
        long tappedWater = 0;
        int[] l_max = leftMax(arr, n);
        int[] r_max = rightMax(arr, n);
        for(int i = 0; i < n; i++){
            int waterLevel = Math.min(l_max[i], r_max[i]);
            tappedWater += waterLevel - arr[i];

        }
        return tappedWater;
    }
}


