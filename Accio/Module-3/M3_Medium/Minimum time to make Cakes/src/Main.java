import java.util.*;

class Main{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int t=sc.nextInt();
            while(t>0){
                int n=sc.nextInt();
                int []A=new int[n];
                int m=sc.nextInt();
                int k=sc.nextInt();
                for(int i=0;i<n;i++){
                    A[i]=sc.nextInt();
                }
                Solution ob =new Solution();
                int ans = ob.minDays(A,n,m,k);
                System.out.println(ans);
                t--;
            }
        }
    }

}
class Solution {
    boolean isPossibleToMake(int[] bloomDay, int n , int m, int k, int cakeCanMake){
        int c = 0; // for make a whole cake after kth falvour to make 1 cake
        int total = 0;// to count total cake
        for(int e : bloomDay){
            if(e <= cakeCanMake){ // id ele is less then ith day, ith flavour is availabl
                c++;// can get the flavour
                if(c == k){// if get all flavour then made 1 cake
                    total++;
                    c = 0;
                }
            }else c = 0;
        }

        return total >= m;
    }
    public int minDays(int[] bloomDay,int n, int m, int k) {
        int min = 0, max = 0;
        for(int ele : bloomDay){
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        int lo = min;
        int hi = max;
        int pAns = -1;
        while(lo <= hi){
            int cakeCanMake = lo + (hi - lo) / 2;
            if(isPossibleToMake(bloomDay, n, m, k, cakeCanMake)){
                pAns = cakeCanMake;
                hi = cakeCanMake -1;
            }else lo = cakeCanMake +1;
        }

        return pAns;
    }
}