//{ Driver Code Starts
import java.util.*;

class Magic
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG gfg = new GfG();
            System.out.println(gfg.binarySearch(arr, 0, n-1));
        }
    }
}

// } Driver Code Ends


class GfG
{
    public static int binarySearch(int arr[], int low, int high)
    {
        // getting mid first
        while(low <= high){
            int mid = (low + high) / 2;
            // if the elment is same with index then return
            if(arr[mid] == mid) return mid;
                // if the value is greater than the idx then move left
            else if(arr[mid] > mid) high = mid-1;
                // else go forward
            else low = mid+1;
        }
        // if no such element present
        return -1;
    }
}