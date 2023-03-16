import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s){
        Stack<Integer> open = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(') open.push(i);
            else if(ch == '*') stars.push(i);
            else{
                if(!open.empty()){
                    open.pop();
                }else{
                    if(!stars.empty()){
                        stars.pop();
                    }
                    else return false;
                }
            }
        }
        if(!open.empty()){
            if(!stars.empty() && open.peek() < stars.peek()){
                stars.pop();
            }else return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}