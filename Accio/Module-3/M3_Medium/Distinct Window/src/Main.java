import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        HashSet<Character> set_s = new HashSet<>();
        for(char ch : s.toCharArray()){
            set_s.add(ch);
        }

        int dmcnt = set_s.size();
        int mcnt = 0;

        int excl = -1;
        int incl = -1;

        String ans = "";

        HashMap<Character, Integer> freqS = new HashMap<>();
        while(true){
            // include the char
            boolean flagIncl = false;
            while(incl+1 < s.length() && mcnt < dmcnt){
                incl += 1;
                char ch = s.charAt(incl);
                freqS.put(ch, freqS.getOrDefault(ch, 0)+1);

                // if i m atlist present then i dont need any more to be unique here
                if(set_s.contains(ch) && freqS.get(ch) == 1){
                    mcnt++;
                }

                flagIncl = true;
            }

            // include the char and check if possible
            boolean flagExcl = false;
            while(excl < incl && mcnt == dmcnt){
                String pAns = s.substring(excl+1, incl+1);
                excl += 1;

                if(ans.length() == 0 || ans.length() > pAns.length()){
                    ans = pAns;
                }

                char ch = s.charAt(excl);
                freqS.put(ch, freqS.get(ch)-1);

                if(set_s.contains(ch) && freqS.get(ch) == 0){
                    mcnt--;
                }

                /* this will also work coz we need unique char that's why
                 if(freqS.get(ch) == 0){
					mcnt--;
				}
                 */

                if(freqS.get(ch) ==0){
                    freqS.remove(ch);
                }

                flagExcl = true;
            }

            // if both loop runs then there possible to get ans
            if(flagIncl == false && flagExcl == false){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}