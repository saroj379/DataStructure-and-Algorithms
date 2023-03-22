import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        Solution obj=new Solution();
        int ans=obj.solve(n);
        System.out.println(ans);
    }
}

class Solution{

    static int solve(int n)
    {
        int c =0;
        while(n > 0){
            if((n & 1) != 0){
                c++;
                break;
            }
            c++;
            n>>=1;
        }
        return c;
    }
}