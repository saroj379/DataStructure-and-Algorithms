package Module_2;

import java.util.Scanner;

class Binary{
    int search(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int l=0,  r=n-1;
        while(l<=n){
            int mid = (l+r)/2;
            if(arr[mid]==k){
                if(arr[mid-1]==k){
                    return mid;
                }
                return mid+1;
            }
            else if(arr[mid]<k){
                l = mid+1;
            }
            else if(arr[mid]>k){
                r=mid-1;
            }
        }
        return -1;
    }
}

public class binarySearch {
    public static void main(String[] args) {
        Binary bs = new Binary();
        int res = bs.search();
        System.out.println(res);
    }
}
