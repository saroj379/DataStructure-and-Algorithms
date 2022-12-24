package Module_3;
import java.util.*;

class Solution{
    //for precedence it will get an integer
    int prece(char c){
        if(c == '^') return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        return -1;
    }

    //infix -> postfix
    String infixToPostfix(String s){
        int n = s.length();
        String ans ="";
        Stack <Character> st = new Stack<>();
        for(int i=0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(ch);
            else if(ch == ')'){
                while(st.size() > 0 && st.peek() != '('){
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            }
            else if(Character.isLetterOrDigit(ch)) ans += ch;
            else{
                while(st.size() > 0 && prece(st.peek()) >= prece(ch)){
                    ans += st.peek();
                    st.pop();
                }
                st.push(ch);
            }
        }
        while(st.size() > 0){
            ans += st.peek();
            st.pop();
        }
        return ans;
    }


    //postfix calculation
    int postfixEvaluation(String s){
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i < n; i++){
            char ch = s.charAt(i);
            if(ch=='+' || ch == '-' || ch == '*' || ch == '/'){
                int op1 = st.pop();
                int op2 = st.pop();
                if(ch == '+') st.push(op2+op1);
                else if(ch == '-') st.push(op2-op1);
                else if(ch == '*') st.push(op2*op1);
                else if(ch == '/') st.push(op2/op1);
            }
            else{
                st.push(ch-'0');
            }
        }
        return st.peek();
    }


    //postfix -> prefix
    String postfixToPrefix(String s){
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch =='+' || ch == '-' || ch == '*' || ch == '/'){
                String op1 = st.pop();
                String op2 = st.pop();
                String ans = ch+op2+op1;
                st.push(ans);
            }
            else st.push(ch+"");
        }
        return st.peek();
    }

    // These function are for
    public void evaluate(String exp){
//        Postfix Evaluation and conversation\
        System.out.println(postfixEvaluation(exp));
        System.out.println(postfixToInfix(exp));
        System.out.println(postfixToPrefix(exp));
    }

    public void evaluation(String exp){
        //infix evaluation and conversation
        String postfix = infixToPostfix(exp);
        System.out.println(postfixEvaluation(postfix));
        System.out.println(postfix);
        System.out.println(postfixToPrefix(postfix));
    }

    //postfix -> infix
    String postfixToInfix(String s){
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                String op1 = st.pop();
                String op2 = st.pop();
                // String res = '('+ op2 +""+ ch +""+ op1 + ')';
                String res = "("+ op2 + ch + op1 + ")";
                st.push(res);
            }
            else st.push(ch+"");
        }
        return st.peek();
    }

}

public class stacks {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        //And we can create obj for the class solution and with the required function we can call here
        System.out.println("Postfix conversion");
        s1.evaluate("264*8/+3-");

        System.out.println();

        System.out.println("Infix conversion");
        s1.evaluation("(A+B)-((C/D)+k)");
    }
}
