import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        if(arr.length % 2 != 0) return false;
        HashMap<Integer, Integer> remFreqMap = new HashMap<>();
        // making the rem with freq
        for(int a: arr){
            int rem = a % k;
            remFreqMap.put(rem, remFreqMap.getOrDefault(rem, 0) +1);
        }


        for(int rem : remFreqMap.keySet()){
            int CompRem = k - rem;
            if(rem == 0){
                continue;
            }
            else if(remFreqMap.get(rem) != remFreqMap.get(CompRem)){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}