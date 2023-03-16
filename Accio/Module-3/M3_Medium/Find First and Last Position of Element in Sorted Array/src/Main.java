import java.util.*;

public class Main {
    // first occurance
    public static int firstOccuranceIdx(int a[], int n, int k){
        int lo = 0, hi = a.length-1;
        int firstOcc = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == k){
                firstOcc = mid;
                hi = mid -1;
            }
            else if(a[mid] > k){
                hi = mid -1;
            }else lo = mid+1;
        }
        return firstOcc;
    }

    // last occurance
    public static int lastOccuranceIdx(int[] a, int n, int k){
        int lo = 0, hi = a.length-1;
        int lastOcc = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == k){
                lastOcc = mid;
                lo = mid + 1;
            }
            else if(a[mid] > k){
                hi = mid -1;
            }else lo = mid+1;
        }
        return lastOcc;
    }
    public static void findPosition(int a[], int n,int k)
    {
        int firstOcc = firstOccuranceIdx(a, n, k);
        int lastOcc = lastOccuranceIdx(a,n,k);
        System.out.println(firstOcc+" "+lastOcc);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}