import java.util.Scanner;

class Solution{
    public static int count7(int n) {
        if(n==0) return 0;
        if(n%10 == 7) return 1 + count7(n/10);
        return count7(n/10);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Solution.count7(n));
    }
}