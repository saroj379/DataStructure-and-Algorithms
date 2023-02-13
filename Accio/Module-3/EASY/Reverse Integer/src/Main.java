import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public int reverseInteger(int x) {
        int sum = 0;
        while(x > 0){
            int rem = x % 10;
            if((rem > Integer.MAX_VALUE/10) || (rem == Integer.MAX_VALUE/10 && rem > 7)){
                return 0;
            }
            if((rem < Integer.MIN_VALUE/10) || (rem == Integer.MIN_VALUE/10 && rem < -8)){
                return 0;
            }
            sum = sum * 10 + rem;
            x /= 10;
        }
        return sum;
    }
}

public class Main {

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.reverseInteger(x));


    }
}