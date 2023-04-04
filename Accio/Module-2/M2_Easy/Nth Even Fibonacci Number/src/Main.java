import java.util.*;
import static java.lang.Math.ceil;

public class Main {
    static long NthEvenFibonacci(long n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 2;
        }
        return (4*NthEvenFibonacci(n-1)%1000000007 + NthEvenFibonacci(n-2)%1000000007)%1000000007;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(NthEvenFibonacci(n));
    }
}