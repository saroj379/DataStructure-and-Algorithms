
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);

    }
}


class Accio {

    static int binarySearch(int arr[], int start, int end, int target){
        int lo = start, hi = end;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) hi = mid -1;
            else lo = mid + 1;
        }
        return -1;
    }

    static int findElement(int arr[], int n,int target)
    {
        int lo = 0, hi = n-1;
        int ans = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] > arr[mid + 1]){
                int start = mid +1, end = n-1;
                while(start <= end){
                    int mid2 = (start + end) / 2;
                    if(arr[mid2] == target) {
                        return mid2;
                    }
                    else if(arr[mid2] > target) {
                        end = mid2 - 1;
                    }
                    else {
                        start = mid2 + 1;
                    }
                }
            }
            else{
                int start = lo, end = mid -1;
                while(start <= end){
                    int mid2 = (start + end) / 2;
                    if(arr[mid2] == target) {
                        return mid2;
                    }
                    else if(arr[mid2] > target) {
                        end = mid2 - 1;
                    }
                    else {
                        start = mid2 + 1;
                    }
                }
                return -1;
            }
        }
        return ans;
    }
}