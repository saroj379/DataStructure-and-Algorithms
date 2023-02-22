import java.util.*;

class Solution {
    // Using Recursion
    public static String removeChars(String S) {
        if(S.length() == 0) return"";
        if(S.charAt(0) == 'a' || S.charAt(0) == 'c' || S.charAt(0) == 'i' || S.charAt(0) == 'o'){
            return removeChars(S.substring(1));
        }
        return S.charAt(0) + removeChars(S.substring(1));
    }


    // using for loops
    public static String removeChars_(String S) {
        String ans = "";
        for(int i =0; i < S.length(); i++){
            if(S.charAt(i) == 'a' || S.charAt(i) == 'c' || S.charAt(i) == 'i' || S.charAt(i) == 'o'){
                continue;
            }else{
                ans += S.charAt(i);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        Solution obj= new Solution();
        String result = obj.removeChars(S);
        System.out.println(result);
    }
}
