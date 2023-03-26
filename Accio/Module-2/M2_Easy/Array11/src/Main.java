import java.util.*;

class Solution
{
    static int count =0;
    static int array11(int[] nums, int index)
    {
        if(nums.length == index){
            return 0;
        }

        if(nums[index] == 11){
            count++;
        }
        array11(nums, index+1);

        return count;
    }
}
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.array11(arr, 0));
    }
}
