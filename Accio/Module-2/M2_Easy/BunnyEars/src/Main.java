import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(bunnyEars(n));
    }
    static int bunnyEars(int n){
        if(n==0){
            return 0;
        }
        return 2+bunnyEars(n-1);
    }
}