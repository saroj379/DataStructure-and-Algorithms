import java.util.*;

public class Main {

    public static int AdisArray(int n, int target, int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target) return mid;

                // if left part is sorted
            else if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && nums[mid] > target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }

            // if right part is sorted
            else{
                if(nums[mid] < target && nums[hi] >= target){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;++i){
            arr[i] = scn.nextInt();
        }

        int ans = AdisArray(n,k,arr);
        System.out.println(ans);
    }
}