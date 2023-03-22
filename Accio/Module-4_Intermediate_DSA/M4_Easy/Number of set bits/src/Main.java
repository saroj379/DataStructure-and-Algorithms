import java.util.*;

class Solution {
    public int setBits(int n) {
        int c =0;
        while(n > 0){

            if((n & 1) != 0){
                c++;
            }
            n>>=1;
        }
        return c;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}