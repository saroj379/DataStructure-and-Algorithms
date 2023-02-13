import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    // public static void sqrt(int A) {
    // 	int ans = 0;
    //        for (int i = 1; i * i <= A; ++i) {
    //            ans = i;
    //        }
    //        System.out.print(ans);
    //    }

    public static void sqrt(int A) {
        long start = 1;
        long last = A;
        long floor_val = 0;
        while(start <= last){
            long mid = (start + last)/2;
            long square = mid * mid;
            if(square == A) {
                System.out.println(mid);
                return;
            }
            else if(square > A){
                last = mid-1;
            }
            else{
                floor_val = mid;
                start = mid+1;
            }
        }
        System.out.println(floor_val);
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        sqrt(A);

    }
}