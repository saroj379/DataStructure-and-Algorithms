import java.util.*;
import java.io.*;
class Solution
{
    static boolean isPossible(int n, int m, int[] arr, int capVal){
        int numberOfOperations = 0;
        for(int e: arr){
            if(e > capVal){
                int currOpe = e / capVal;
                if(e % capVal == 0){
                    currOpe -= 1;
                }
                numberOfOperations += currOpe;
            }
        }
        return numberOfOperations <= m;
    }
    public static int solve(int n,int m,int arr[])
    {
        // Write your code here
        int lo = 1;
        int hi = 0;
        for(int e: arr){
            hi = Math.max(hi, e);
        }

        int pAns = 0;
        while(lo <= hi){
            int capValue = (lo + hi) /2;
            if(isPossible(n, m, arr, capValue)){
                pAns = capValue;
                hi =capValue-1;
            }else lo = capValue +1;
        }

        return pAns;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}