//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
    long floorSqrt(long x)
    {
        long st = 1, end = x, potLeft = 0;
        while(st <= end){
            long mid = (st + end) / 2;
            long sqr = mid * mid;
            if(sqr == x) return mid;
            else if(sqr > x) end = mid -1;
            else{
                potLeft = mid;
                st = mid + 1;
            }
        }
        return potLeft;
    }
}
