import java.util.*;

public class Main {
    // 1st question
    public static boolean atLeastTwiceOfElement(int a[]){
        int n = a.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(a[i] == a[j]){
                    return true;
                }
            }
        }
        return false;
    }


    // 2nd question
    public static int minIndex(int arr[]){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(mid > 0 && arr[mid - 1] > arr[mid]) return mid;
            else if(arr[l] <= arr[mid] && arr[mid] > arr[r]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
    public static int findIndexOfTarget(int[] a, int target){
        int min = minIndex(a);
        // find in sorted left
        if(a[min] <= target && target <= a[a.length - 1]){
            return search(a, target, min, a.length);
        }else return search(a, target, 0, min);
    }
    public static int search(int arr[], int target, int left, int right){
        int start = left, end = right;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                start = mid + 1;
            }else end = mid - 1;
        }
        return -1;
    }


    // 3rd question
    public static int maxProfit(int price[]){
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < price.length; i++){
            if(buyPrice < price[i]){
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }


    // 4th question
    // left max
    public static int[] leftMax(int h[]){
        int n = h.length;
        int lm[] = new int[n];
        lm[0] = h[0];
        for(int i = 1; i < n; i++){
            lm[i] = Math.max(lm[i - 1], h[i]);
        }
        return lm;
    }
    //right max
    public static int[] rightMax(int h[]){
        int n = h.length;
        int rm[] = new int[n];
        rm[n - 1] = h[n - 1];
        for(int i = n-2; i >= 0; i--){
            rm[i] = Math.max(rm[i + 1], h[i]);
        }
        return rm;
    }
    public static int tappedWater(int[] height){
        int[] l_max = leftMax(height);
        int[] r_max = rightMax(height);
        int totWater = 0;
        for(int i = 0; i < height.length; i++){
            int waterLevel = Math.min(l_max[i], r_max[i]);
            totWater += waterLevel - height[i];
        }
        return totWater;
    }


    // Return Triplets
    public static List<List<Integer>> tripletList(int[] arr){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i =0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    if((arr[i] + arr[j] + arr[k]) == 0){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        list.add(triplet);
                    }
                }
            }
        }
        list = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>>(list));
        return list;
    }


    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 9, 0, 1};
        System.out.println("isDouble: "+atLeastTwiceOfElement(nums));

        // 2
        System.out.println("Index of the Target Element: "+findIndexOfTarget(nums, 3));

        //3
        int[] prices = { 7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit: "+maxProfit(prices));

        // 4
        int[] height = {4, 2, 0, 3, 2, 1};
        System.out.println("Tapped total Water: "+tappedWater(height));

        // 5
        int a[] = {-1, 0, 1, 2, -1, -4};
        System.out.println("All the Possible Triplets: "+tripletList(a));
    }
}