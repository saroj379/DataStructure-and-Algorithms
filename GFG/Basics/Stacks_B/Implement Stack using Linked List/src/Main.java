//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;

    //Function to push an integer into the stack.

    // pushing at head position
    void push(int a)
    {
        // Add your code here
        StackNode sn = new StackNode(a);
        if(top == null){
            top = sn;
            return;
        }
        sn.next = top;
        top = sn;
    }

    // removing the head too
    //Function to remove an item from top of the stack.
    int pop()
    {
        if(top == null) return -1;
        int ans = top.data;
        top = top.next;

        return ans;
    }
}
