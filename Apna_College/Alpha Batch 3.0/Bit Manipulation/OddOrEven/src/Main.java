public class Main {
    // Odd or Even using bit-wise operator
    public static void oddOrEven(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }

    public static void main(String[] args) {
        oddOrEven(3);
        oddOrEven(18);
    }
}