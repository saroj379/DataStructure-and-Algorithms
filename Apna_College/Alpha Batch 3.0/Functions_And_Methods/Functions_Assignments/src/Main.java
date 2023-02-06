import java.util.*;

class fun{
    public double avgOfThreeNumbers(int a, int b, int c){
        return (a + b + c) / 3;
    }

    boolean isEven(int n){
        return (n % 2 == 0) ? true : false;
    }

    boolean isPalindrom(int n){
        int copy = n;
        int rev =0;
        while(n > 0){
            int rem = n % 10;
            rev = rem + (rev * 10);
            n /= 10;
        }
        return (copy == rev);
    }

    int sumOfDigit(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fun f = new fun();

        // Avg of 3 nos
        System.out.println("Enter 3 nos: ");
        int num1 = sc.nextInt(), num2 = sc.nextInt(), num3 = sc.nextInt();
        System.out.println(f.avgOfThreeNumbers(num1, num2, num3));

        // Return true if Even
        System.out.print("Enter a number for Checking Even or not: ");
        int num4 = sc.nextInt();
        System.out.println(f.isEven(num4));

        // Check Palindrom or not
        System.out.println("Enter a number for checking Palindrom or not: ");
        int num5 = sc.nextInt();
        System.out.println(f.isPalindrom(num5));

        // Sum of Digits
        System.out.println("Enter a number to give the sum of digits: ");
        int num6 = sc.nextInt();
        System.out.println(f.sumOfDigit(num6));
    }
}