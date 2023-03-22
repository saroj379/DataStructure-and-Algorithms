

import java.util.*;

class Solution {
    public void singleElement(int[]A,int n) {
        int res = 0;
        for(int x: A){
            res ^= x;
        }
        System.out.print(res);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.singleElement(A,n);
        sc.close();
    }
}

