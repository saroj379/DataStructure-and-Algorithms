//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    // to firnd the occurance of that particular element
    int firstOccurance(long[] arr, int n, int x){
        int lo = 0, hi = n-1;
        int potential_left = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == x){
                // may b i have same element on left, so going back with storing the curr 1
                potential_left = mid;
                hi = mid-1;
            }
            else if(arr[mid] > x)hi = mid-1;
            else lo = mid+1;
        }
        return potential_left;
    }

    // to find the last occurance
    int lastOccurance(long[] arr, int n, int x){
        int lo = 0, hi = n-1;
        int potential_right = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == x){
                // may b i have same element on right, so going forward with storing the curr 1
                potential_right = mid;
                lo = mid+1;
            }
            else if(arr[mid] > x)hi = mid-1;
            else lo = mid+1;
        }
        return potential_right;
    }


    ArrayList<Long> find(long arr[], int n, int x)
    {
        long f_occur = firstOccurance(arr, n, x);
        long l_occur = lastOccurance(arr, n, x);

        ArrayList<Long> list = new ArrayList<>();
        list.add(f_occur);
        list.add(l_occur);

        return list;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends