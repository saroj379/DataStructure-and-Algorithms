import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        long ans = Solution.efficientManufacturing(n, k, arr);
        System.out.println(ans);
    }
}
class Solution
{
    static boolean isPossible(int[] factory, long days, int target){
        long productProduce = 0;
        for(int time : factory){
            long productProducedInGivenDays = days / time;
            productProduce += productProducedInGivenDays;
        }
        return productProduce >= target;
    }


    static long efficientManufacturing(int n, int k, int arr[])
    {
        if(arr.length == 1) return arr[0] * k;
        long slowestFactory = 0;
        for(int i =0; i < arr.length; i++){
            slowestFactory = Math.max(slowestFactory, arr[i]);
        }
        // minimum days to make k items
        long lo = 1;
        // maximumdays to make the k items
        long hi = slowestFactory * k;
        long ans = -1;
        while(lo <= hi){
            long days = (lo + hi) / 2;
            // is possible to make k items in the given days
            if(isPossible(arr, days, k)){
                ans = days;
                hi = days - 1;
            }else{
                lo = days +1;
            }
        }
        return ans;
    }
}