//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Node head = new Node( s.charAt(0) - '0' );
            Node tail = head;
            for(int i=1; i<s.length(); i++)
            {
                tail.next = new Node( s.charAt(i) - '0' );
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    static Node reverseList(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node nxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static Node addOne(Node head)
    {
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node h1 = reverseList(head);

        int carry =1;

        while(h1 != null){
            int sum = h1.data + carry;
            int rem = sum % 10;

            Node nn = new Node(rem);
            curr.next = nn;
            curr = nn;

            carry = sum/10;
            h1 = h1.next;
        }

        if(carry >0){
            Node nn = new Node(carry);
            curr.next = nn;
            curr = nn;
        }

        return reverseList(dummy.next);
    }
}
