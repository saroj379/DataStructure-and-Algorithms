import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for(int i=0; i<q; i++){
            int a = sc.nextInt();//5
            int b = sc.nextInt();//3
            int n = sc.nextInt();//5

            int sum = a;
            for(int k=0; k<n; k++){
                sum += (Math.pow(2, k) * b);
                System.out.print(sum+ " ");
            }
            System.out.println();
        }
    }
}
