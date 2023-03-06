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

    // get ith bit
    public static int get_ithBit(int n, int i){
        int bitMask = 1 << i;
        if((n & bitMask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    // set ith bit
    public static int set_ithBit(int n, int i){
        int bitMask = 1 << i;
        return n | bitMask;
    }

    // clear ith bit
    public static int clear_ithBit(int n, int i){
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    // Update ith bit
    public static int update_ithBit(int n, int i, int newBit) {
        // approach 1
//        if(newBit == 0){
//            return clear_ithBit(n, i);
//        }else{
//            return set_ithBit(n, i);
//        }


        // 2nd approach
        n = clear_ithBit(n ,i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static void main(String[] args) {
        // Odd or Even using bit-wise operator
        oddOrEven(3);
        oddOrEven(18);

        // get ith bit
        System.out.println("Get ith bit : "+get_ithBit(15, 2));
        System.out.println("Get ith bit : "+get_ithBit(10, 2));
        System.out.println("Get ith bit : "+get_ithBit(15, 3));

        // set ith bit
        System.out.println("Set ith bit : "+set_ithBit(10, 2));

        // clear ith bit
        System.out.println("CLear ith bit : "+clear_ithBit(10, 1));
    }
}