import java.io.*;
import java.util.*;

public class Main {
    static int isPalindrome(String str)
    {
        str = str.toUpperCase();
        int l = 0, r = str.length()-1;
        while(l < r){
            if(!((str.charAt(l) >='a' && str.charAt(l)<='z') || (str.charAt(l) >='A' && str.charAt(l)<='Z'))){
                l++;
                continue;
            }
            if(!((str.charAt(r) >='a' && str.charAt(r)<='z') || (str.charAt(r) >='A' && str.charAt(r)<='Z'))){
                r--;
                continue;
            }

            // if not same letters then return false as 0
            if(str.charAt(l) != str.charAt(r)) return 0;
            l++;
            r--;
        }
        // if successful pass this loop then this is palindrom
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);
    }
}