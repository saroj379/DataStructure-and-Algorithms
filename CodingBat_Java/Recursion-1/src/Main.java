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

    // changeXY
    public String changeXY(String str) {
        if(str.length() == 0)  return "";
        if(str.charAt(0)=='x'){
            return 'y'+changeXY(str.substring(1));
        }
        return str.charAt(0)+changeXY(str.substring(1));
    }

    // changePi
    public String changePi(String str) {
        if(str.length() == 0) return "";
        if(str.length() >= 2 && str.substring(0,2).equals("pi")){
            return "3.14" + changePi(str.substring(2));
        }
        return str.charAt(0) + changePi(str.substring(1));
    }

    // noX
    public String noX(String str) {
        if(str.length() ==0) return "";
        if(str.charAt(0) == 'x'){
            return noX(str.substring(1));
        }
        return str.charAt(0) + noX(str.substring(1));
    }

    // array6
    public boolean array6(int[] nums, int index) {
        if(index == nums.length){
            return false;
        }

        if(nums[index] == 6){
            return true;
        }
        return array6(nums, index+1);
    }

    // array220
    public boolean array220(int[] nums, int index) {
        if(nums.length-1 <= index) return false;
        if(nums[index] * 10 == nums[index+1]) return true;
        return array220(nums, index+1);
    }

    // allStar
    public String allStar(String str) {
        if(str.equals("") || str.length() == 1) return str;
        return str.charAt(0)+ "*" + allStar(str.substring(1));
    }

    // pairStar
    public String pairStar(String str) {
        if(str.length() <= 1) return str;
        if(str.charAt(0) == str.charAt(1)){
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        }
        return str.charAt(0) + pairStar(str.substring(1));
    }

    // endX
    public String endX(String str) {
        if(str.length() == 0) return str;
        if(str.charAt(0) == 'x'){
            return endX(str.substring(1)) + str.charAt(0);
        }
        return str.charAt(0) + endX(str.substring(1));
    }

    // countPairs
    public int countPairs(String str) {
        if(str.length() <= 2) return 0;
        if(str.charAt(0) == str.charAt(2)){
            return 1 + countPairs(str.substring(1));
        }
        return countPairs(str.substring(1));
    }

    // countAbc
    public int countAbc(String str) {
        if(str.length() <=2) return 0;
        if(str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba")){
            return 1 + countAbc(str.substring(1));
        }
        return countAbc(str.substring(1));
    }

    // count11
    public int count11(String str) {
        if(str.length() < 2) return 0;
        if(str.substring(0,2).equals("11")){
            return 1 + count11(str.substring(2));
        }
        return count11(str.substring(1));
    }

    // stringClean
    public String stringClean(String str) {
        if(str.length() <= 1) return str;
        if(str.charAt(0) == str.charAt(1)){
            return stringClean(str.substring(1));
        }
        return str.charAt(0) + stringClean(str.substring(1));
    }

    // countHi2
    public int countHi2(String str) {
        if(str.length() < 2) return 0;
        if(str.charAt(0) == 'x'){
            if(str.length() > 2 && str.substring(1,3).equals("hi")){
                return countHi2(str.substring(2));
            }
            else{
                return countHi2(str.substring(1));
            }
        }else if(str.substring(0,2).equals("hi")){

            return 1 + countHi2(str.substring(1));
        }
        return countHi2(str.substring(1));

    }

    // optimized code
    public int countHi2_(String str) {
        int len = str.length();
        if(len < 2) return 0;
        if(str.substring(len-2, len).equals("hi")){
            if(len >2 && str.charAt(len-3)!='x' || len==2){
                return 1 + countHi2(str.substring(0, len-1));
            }
        }
        return countHi2(str.substring(0, len-1));
    }

    // parenBit
    public String parenBit(String str) {
        if(str.equals("")) return str;
        if(str.charAt(0) == '('){
            if(str.charAt(str.length()-1) == ')'){
                return str;
            }else{
                return parenBit(str.substring(0, str.length()-1));
            }
        }
        return parenBit(str.substring(1));
    }

    // nestParen
    public boolean nestParen(String str) {
        int len = str.length();
        if(len == 0) return true;
        if(str.charAt(0) == '(' && str.charAt(len-1) == ')'){
            return nestParen(str.substring(1, len -1));
        }
        return false;
    }

    // strCount
    public int strCount(String str, String sub) {
        int lenSub = sub.length();
        int len = str.length();
        if(len < lenSub) return 0;
        if(str.substring(len-lenSub, len).equals(sub)){
            return 1 + strCount(str.substring(0, len-lenSub), sub);
        }
        return strCount(str.substring(0, len-1), sub);
    }

    // strCopies
    public boolean strCopies(String str, String sub, int n) {
        int lenSub = sub.length();
        int len = str.length();
        if(len < lenSub){
            if(n==0) return true;
            else return false;
        }
        if(len >= lenSub && str.substring(len-lenSub, len).equals(sub)){
            return strCopies(str.substring(0, len-1), sub, n-1);
        }
        return strCopies(str.substring(0, len-1), sub, n);
    }

    // strDist
    public int strDist(String str, String sub) {
        return func(str,sub).length();
    }

    private String func(String str, String sub) {
        int lenSub = sub.length();
        int len = str.length();

        if(str.equals("")) return str;
        if(str.startsWith(sub)){
            if(str.substring(len-lenSub, len).equals(sub)){
                return str;
            }
            else{
                return func(str.substring(0, len-1), sub);
            }
        }
        return func(str.substring(1, len), sub);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}