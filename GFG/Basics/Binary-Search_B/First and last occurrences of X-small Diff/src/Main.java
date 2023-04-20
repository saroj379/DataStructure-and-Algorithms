//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int arr[] = new int[(int)(n)];

            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x);

            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}




// } Driver Code Ends


//User function Template for Java
class Solution{
    // for first occurance
    int firstOccurance(int a[], int n, int x){
        int lo=0, hi= n-1, potential_left = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == x){
                potential_left = mid;
                hi = mid-1;
            }else if(a[mid] > x){
                hi = mid-1;
            }else lo = mid+1;
        }
        return potential_left;
    }

    // last occurance
    int lastOccurance(int a[], int n, int x){
        int lo=0, hi= n-1, potential_right = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == x){
                potential_right = mid;
                lo = mid+1;
            }else if(a[mid] > x){
                hi = mid-1;
            }else lo = mid+1;
        }
        return potential_right;
    }

    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        int f_occur = firstOccurance(arr, n, x);
        int l_occur = lastOccurance(arr, n, x);

        ArrayList<Integer> list = new ArrayList<>();
        if(f_occur == -1 && l_occur == -1) list.add(-1);// if element not present then return -1 once
        else{
            list.add(f_occur);
            list.add(l_occur);
        }

        return list;
    }
}
