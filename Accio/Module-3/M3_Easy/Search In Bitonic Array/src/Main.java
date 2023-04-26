
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
    // get the peak element
    static int peekElementIndex(int arr[], int n){
        int lo = 0;
        int hi = n-1;
        while(lo <= hi){
            int mid = (lo + hi) /2;
            if(mid-1 < 0){
                if(arr[mid] > arr[mid+1]) return mid;
                else lo = mid +1;
            }
            else if(mid+1 >= n){
                if(arr[mid] > arr[mid-1]) return mid;
                else hi = mid -1;
            }
            else{
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
                else if(arr[mid] > arr[mid-1]){
                    lo = mid+1;
                }else hi = mid-1;
            }
        }
        return -1;
    }

    static int findElement(int arr[], int n,int target)
    {
        int peek = peekElementIndex(arr, n);
        if(arr[peek] == target) return peek; // if the element is the peak
        int lo = 0;
        int hi = peek-1;
        // check for left sorted part isPresent or not
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) hi = mid -1;
            else lo = mid +1;
        }

        lo = peek+1;
        hi = n-1;
        // if not present on left it will come to this loop to check for right part
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) lo = mid +1;
            else hi = mid -1;
        }
        // if not present then return -1
        return -1;
    }
}