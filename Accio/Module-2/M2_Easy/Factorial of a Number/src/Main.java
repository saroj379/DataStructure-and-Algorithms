import java.util.*;

class Solution {
    static long factorial(int n)
    {
        // corner case
        if(n <= 0) return 1;
        // faith for n-1, exp for n
        return n * factorial(n-1);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.factorial(n));
    }
}