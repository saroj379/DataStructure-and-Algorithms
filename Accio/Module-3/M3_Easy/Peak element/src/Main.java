import java.util.*;

class Solution{
    public int findPeak(int arr[], int n)
    {
        int lo = 0;
        int hi = n-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            // check there is no left and this is peek (first ele)
            if(mid -1 < 0){
                if(arr[mid] > arr[mid+1]) return mid;
                else lo = mid +1;// else go and check right part
            }
            // check wherethere right part is not there but last element is peak
            else if(mid +1 >= n){
                if(arr[mid] > arr[mid-1]) return mid;
                else hi = mid -1;// check for left part
            }
            // there is the peak on the mid
            else{
                // if i m the pick then return myself
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
                if(arr[mid-1] <= arr[mid]){
                    // System.out.println("hi");
                    lo = mid +1;
                }else hi = mid -1;
            }
        }

        return -1;
    }
}

class Main{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int t=sc.nextInt();
            while(t>0){
                int n=sc.nextInt();
                int []A=new int[n];
                for(int i=0;i<n;i++){
                    A[i]=sc.nextInt();
                }
                Solution ob =new Solution();
                int ans = ob.findPeak(A,n);
                // System.out.println(ans);
                if(ans==0){
                    if(A[ans]>A[ans+1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                else if(ans==n-1){
                    if(A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                else{
                    if(A[ans]>A[ans+1] && A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }
                t--;
            }
        }
    }
}