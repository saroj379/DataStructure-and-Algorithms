class Solutions{

    // factorial
    public int factorial(int n) {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    // bunnyEars
    public int bunnyEars(int bunnies) {
        if(bunnies==0){
            return 0;
        }
        return 2+bunnyEars(bunnies-1);
    }

    // fibonacci
    public int fibonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    // bunnyEars2
    public int bunnyEars2(int bunnies) {
        if(bunnies==0){
            return 0;
        }
        if(bunnies%2!=0){
            return 2+bunnyEars2(bunnies-1);
        }
        return 3+bunnyEars2(bunnies-1);
    }

    //  triangle
    public int triangle(int rows) {
        if(rows==0){
            return 0;
        }
        return rows+triangle(rows-1);
    }

    // sumDigits
    public int sumDigits(int n) {
        if(n==0){
            return 0;
        }
        return (n%10)+sumDigits(n/10);
    }

    // count7
    public int count7(int n) {
        if(n==0){
            return 0;
        }
        if(n%10==7){
            return 1+count7(n/10);
        }else {
            return count7(n / 10);
        }
    }

    // count8
    public int count8(int n) {
        if(n==0){
            return 0;
        }
        if(n%10==8){
            return 1+count8(n/10);
        }
        return count8(n/10);
    }

    // powerN
    public int powerN(int base, int n) {
        if(n==1){
            return base;
        }
        return base*powerN(base,n-1);
    }

    // countX
    public int countX(String str) {
        if(str.length()==0){
            return 0;
        }
        if(str.charAt(0)=='x'){
            return 1 + countX(str.substring(1));
        }
        return countX(str.substring(1));
    }

    // countHi
    public int countHi(String str) {
        if(str.length()<2){
            return 0;
        }
        if(str.substring(0,2).equals("hi")){
            return 1 + countHi(str.substring(1));
        }else{
            return countHi(str.substring(1));
        }
    }

    // 

}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}