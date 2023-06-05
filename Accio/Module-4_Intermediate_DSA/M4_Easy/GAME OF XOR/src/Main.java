import java.util.*;
class Solution
{
    static int xorSubarrayXors(int arr[], int n) {
        if((n & 1) != 1) return 0;
        int xorOfSubArray = 0;
        for(int i=0; i<n; i++){
            if((i & 1) != 1) xorOfSubArray ^= arr[i];
        }
        return xorOfSubArray;
    }

}
public class Main {



    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}