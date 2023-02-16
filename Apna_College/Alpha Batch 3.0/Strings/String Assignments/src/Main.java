import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // how many lowercase vowels present
    public static int countLowerVowels(String str){
        int count =0;
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) =='a' || str.charAt(i) == 'e' || str.charAt(i) =='i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }

    // Check string is Palindrom or not
    public static boolean checkPalindrom(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }

        return true;
    }


    // 2 Strings anagram or not
    public static boolean checkAnagram(String str1, String str2){
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        if(s1.length() == s2.length()){
            char[] str1charArr = str1.toCharArray();
            char[] str2charArr = str2.toCharArray();
            Arrays.sort(str1charArr);
            Arrays.sort(str2charArr);

            boolean result = Arrays.equals(str1charArr, str2charArr);
            if(result) return true;
            else return false;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Number of Lower vowels on this string: "+countLowerVowels(s));

        // Check string is palindrom or not
        String s1 = sc.nextLine();
        System.out.println("Is this string is Palindrom?\n"+checkPalindrom(s1));

        // Check 2 strings are anagram or not
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("Are these strings Anagram?\n"+ checkAnagram(str1, str2));
    }
}