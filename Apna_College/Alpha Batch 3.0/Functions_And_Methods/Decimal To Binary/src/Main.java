import java.util.Scanner;

public class Main {
    // Decimal  -> Binary
    public static  int decimalToBinary(int n){
        int binVal =0, pwr  =0;
        while(n > 0){
            int rem = n % 2;
            binVal += rem *  Math.pow(10,pwr);
            pwr++;
            n /= 2;
        }
        return binVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Decimal Value, Which will convert to Binary: ");
        System.out.print(decimalToBinary(sc.nextInt()));
    }
}