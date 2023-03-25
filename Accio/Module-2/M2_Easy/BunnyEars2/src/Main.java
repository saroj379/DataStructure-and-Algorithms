import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(bunnyEars2(n));
    }
    static int bunnyEars2(int n){
        if(n==0){
            return 0;
        }
        else if(n%2!=0){
            return 2 + bunnyEars2(n-1);
        }
        return 3 + bunnyEars2(n-1);
    }
}