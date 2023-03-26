import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static long dig(long n){
        long ans =0;
        while(n>0){
            ans+=n%10;
            n/=10;
        }
        return ans;
    }
    public static long rec(long n){
        if(n<10){
            return n;
        }
        return rec(dig(n));
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long curr= 0;
        for(int i=0;i<s.length(); i++){
            curr+=s.charAt(i)-'0';
        }
        int k = sc.nextInt();
        curr *= k;
        System.out.println(rec(curr));
    }
}