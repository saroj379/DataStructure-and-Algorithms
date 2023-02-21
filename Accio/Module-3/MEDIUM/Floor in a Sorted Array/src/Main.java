
import java.util.*;
import java.io.*;

public class Main {
    public static int floorOfSortedArray(int[] arr, int k){
        int lo = 0, hi = arr.length-1, potentialLeft = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            // if target is equal to mid value
            if(arr[mid] == k) return mid;

                // if middle element is greater
            else if(arr[mid] > k) hi = mid - 1;

                // keep the just smaller element
            else{
                // just storing the value if there will such value
                potentialLeft = mid;
                lo = mid + 1;
            }
        }
        return potentialLeft;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i <n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(floorOfSortedArray(arr, k));
    }
}