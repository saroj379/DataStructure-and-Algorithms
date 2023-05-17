import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freqt = new HashMap<>();
        // to make the freqmap for t string(sort string)
        for(char ch : t.toCharArray()){
            freqt.put(ch, freqt.getOrDefault(ch, 0)+1);
        }

        int dmcnt = t.length();
        int mcnt = 0;

        int incl = -1;
        int excl = -1;

        String ans = "";

        HashMap<Character, Integer> freqs = new HashMap<>();
        while(true){

            // including part
            boolean flagIncl = false;
            // while the incl is in the length of s string
            while(incl+1 < s.length() && mcnt < dmcnt){
                incl += 1;

                // get the char and set it on freqs map
                char ch = s.charAt(incl);
                freqs.put(ch, freqs.getOrDefault(ch, 0)+1);

                // if the freqt map contains mean the sort string has the char or not and the requird freq for t-string is less then increase match count means it need
                if(freqt.containsKey(ch) && freqt.get(ch) >= freqs.get(ch))
                { mcnt++;}

                flagIncl = true;
            }

            // excluding part
            boolean flagExcl = false;
            while(excl < incl && mcnt == dmcnt){
                String pAns = s.substring(excl +1, incl+1);// can be mu potentian ans

                // if my ans is empty or if i am getting a sort string ans then update it
                if(ans.length() == 0 || pAns.length() < ans.length()){
                    ans = pAns;
                }
                // move excl to remove umnexessary char if possible
                excl += 1;
                char ch = s.charAt(excl);
                freqs.put(ch, freqs.get(ch)-1);// it will remove the char once

                if(freqt.containsKey(ch) && freqt.get(ch) > freqs.get(ch)){
                    mcnt--;
                }

                // if the char is not match mean it has 0 freq then remove it form map
                if(freqs.get(ch) == 0) freqs.remove(ch);
                flagExcl = true;
            }

            // if both part will not attain mean we won't have ans so it will break the loop
            if(flagIncl == false && flagExcl == false)
                break;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}