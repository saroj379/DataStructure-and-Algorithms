import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){

        HashMap<Character, Integer> freq = new HashMap<>();

        String ans = "";

        int incl = -1;
        int excl = -1;
        while(true){
            // include
            boolean flagIncl = false;
            while(incl+1 < s.length() && freq.size() <= k){
                incl +=1;

                char ch = s.charAt(incl);
                freq.put(ch, freq.getOrDefault(ch, 0)+1);

                if(freq.size() == k){
                    String pAns = s.substring(excl+1, incl+1);
                    if(ans.length() == 0 || ans.length() < pAns.length()){
                        ans = pAns;
                    }
                }
                flagIncl = true;
            }

            // exclude
            boolean flagExcl = false;
            while(excl < incl && freq.size() > k){

                excl+=1;

                char ch = s.charAt(excl);
                freq.put(ch, freq.get(ch)-1);

                if(freq.get(ch) == 0) freq.remove(ch);

                flagExcl = true;
            }

            if(flagIncl == false && flagExcl == false){
                break;
            }
        }
        if(ans.length() > 0) return ans.length();
        return -1;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}