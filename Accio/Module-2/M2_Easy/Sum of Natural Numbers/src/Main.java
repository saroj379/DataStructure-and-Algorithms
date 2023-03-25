import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //your code here
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        long res = sumOfNatural(input);
        System.out.print(res);
    }

    public static long sumOfNatural(int n){
        // base case
        if(n <= 1) return n;
        return (n * n+1)/2;

        // normal for loops
        // long sum =0;
        // for(int i =1; i<=n; i++){
        // 	sum += i;
        // }
        // return sum;
    }
}