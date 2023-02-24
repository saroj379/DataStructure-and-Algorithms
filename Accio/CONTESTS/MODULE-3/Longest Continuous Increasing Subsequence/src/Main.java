import java.util.*;

class Solution {
    public static int minDifference(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;
        int potentialLeft = 0, potentialRight = arr.length-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == key) return arr[mid];
            else if(arr[mid] > key){
                potentialRight = mid;
                hi = mid -1;
            }
            else{
                potentialLeft = mid;
                lo = mid +1;
            }
        }
        int left = key - arr[potentialLeft];
        int right = arr[potentialRight] - key;
        if(left < right) return arr[potentialLeft];
        return arr[potentialRight];
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution obj= new Solution();
        System.out.println(obj.minDifference(a,k));
    }
}
