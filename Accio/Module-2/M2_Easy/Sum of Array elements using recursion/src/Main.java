import java.util.*;
class Solution{
    public static int sumofArrayRec(int[] arr, int n) {
        if( n == 0){
            return 0;
        }
        // my faith -> is to get sum of n-1 items in array
        return arr[n-1] + sumofArrayRec(arr, n-1);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(Solution.sumofArrayRec(arr, n));
    }
}