//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Stack<Integer> s=new Stack<>();
            int n=sc.nextInt();
            while(n-->0)
                s.push(sc.nextInt());
            GfG g=new GfG();
            Stack<Integer> a=g.sort(s);
            while(!a.empty()){
                System.out.print(a.peek()+" ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> srt = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        while(!s.empty()){
            // if there is no elements then obviously single ele is always sorted
            if(srt.empty()) srt.push(s.pop());
                // check the peek;
            else{
                while(!srt.empty() && srt.peek() >= s.peek()){
                    temp.push(srt.pop());
                }
                srt.push(s.pop());
                while(!temp.empty()){
                    srt.push(temp.pop());
                }
            }
        }

        return srt;
    }
}