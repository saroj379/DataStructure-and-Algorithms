import java.io.*;
import java.util.*;
import java.util.*;

class Solution{
    public static boolean isPossibleDistance(int[] a, int cows, int dist){
        int lastPosition = 0;
        int numberOfCows = 1;
        for(int i = 1; i < a.length; i++){
            int distanceBetweenLastposAndCurrpos = a[i]-a[lastPosition];
            if(distanceBetweenLastposAndCurrpos >= dist){
                numberOfCows++;
                lastPosition = i;
            }
        }
        return numberOfCows >= cows;
    }
    public static int aggressiveCows(int a[],int cows){
        Arrays.sort(a);
        int minDistance = 1;
        int maxDistance = a[a.length - 1] - a[0];
        int ans = 0;

        while(minDistance <= maxDistance){
            int capacitDist = (minDistance + maxDistance) / 2;
            if(isPossibleDistance(a, cows, capacitDist)){
                ans = capacitDist;
                minDistance = capacitDist + 1;
            }else{
                maxDistance = capacitDist - 1;
            }
        }

        return ans;
    }


}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.aggressiveCows(nums,k));

    }
}
