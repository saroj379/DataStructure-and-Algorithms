//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{

    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverseList(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node nxtOfCurr = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxtOfCurr;
        }
        return prev;
    }

    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node f = reverseList(first);
        Node s = reverseList(second);

        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry =0;
        while(f != null && s != null){
            int sum = (f.data + s.data) + carry;
            Node nn = new Node(sum % 10);
            carry = sum /10;
            temp.next = nn;
            temp = temp.next;

            f = f.next;
            s = s.next;
        }
        while(f != null){
            int sum = f.data + carry;
            Node nn = new Node(sum % 10);
            carry = sum /10;
            temp.next = nn;
            temp = temp.next;

            f = f.next;
        }
        while(s != null){
            int sum = s.data + carry;
            Node nn = new Node(sum % 10);
            carry = sum /10;
            temp.next = nn;
            temp = temp.next;

            s = s.next;
        }
        if(carry > 0){
            Node nn = new Node(carry);
            temp.next = nn;
        }

        Node ans = reverseList(dummy.next);

        return ans;
    }
}