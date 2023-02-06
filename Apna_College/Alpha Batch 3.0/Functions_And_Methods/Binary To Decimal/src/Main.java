import java.util.Scanner;

public class Main {
    public static int binaryToDecimal(int n){
        int decVal =0;int pwr =0;
        while(n > 0){
            int rem = n % 10;
            decVal += (int)(rem  * Math.pow(2,pwr));
            n /= 10;
            pwr++;
        }
        return decVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Binary Value, Which will convert to Decimal: ");
        System.out.print(binaryToDecimal(sc.nextInt()));
    }
}