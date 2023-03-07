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

    // Clear last ith bits
    public static int clear_lastBits(int n, int i){
        int bitMAsk = (~0) << i;
        return n & bitMAsk;
    }

    // Clear bits in Range
    public static int clear_rangeBits(int n, int i ,int j){
        int a = ((~0) << (j+1));
        int b = (1 << i) -1;
        int bitMask = a | b;
        return n & bitMask;
    }

    // is power of 2
    public static boolean isPowerOf2(int n){
        return ((n & (n-1) )== 0);
    }

    // Count set bits
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }

        return count;
    }

    // Fast Exponentiation
    public static int fastExpo(int a, int n) {
        int ans = 1;

        while(n > 0){
            if((n & 1) != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }

        return ans;
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

        // clear last ithe bits
        System.out.println("CLear last ith bit : "+clear_lastBits(15, 2));

        // clear bits in range
        System.out.println("CLear bits in range : "+clear_rangeBits(10, 2, 4));

        // is power of 2
        System.out.println("Is power of 2 : "+isPowerOf2(8));

        // count set bits
        System.out.println("number  of set bits : "+countSetBits(2));

        // Fast Expo
        System.out.println("Fast Exponetiation : "+fastExpo(2,10));
    }
}