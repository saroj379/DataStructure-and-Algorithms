public class Main {

    // Swap 2 nos using XOR
    public static void main(String[] args) {
        swap(3, 5);

        adding1(5);

        upperToLower();
    }


    // Swap 2 nos
    public static void swap(int x, int y){
        System.out.println("Before Swap: X -> " + x + " ,Y -> "+y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After Swap: X -> " + x + " ,Y -> "+y);
    }

    // Add 1 with given number using bits
    public static void adding1(int x){
        System.out.println(x + " + " + 1 + " is "+ --x);
        x = -4;
        System.out.println(x + " + " + 1 + " is "+ --x);
        x = 0;
        System.out.println(x + " + " + 1 + " is "+ --x);
    }


    //
    public static void upperToLower(){
        for(char ch = 'A'; ch <= 'Z'; ch++){
            System.out.println((char)(ch | ' '));
        }
    }
}