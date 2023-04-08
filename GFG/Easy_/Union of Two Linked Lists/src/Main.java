//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int a)
    {
        data = a;
        next = null;
    }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);

    public static Node inputList(int size)
    {
        Node head, tail;
        int val;

        val = sc.nextInt();

        head = tail = new Node(val);

        size--;

        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;

            n = sc.nextInt();
            Node head1 = inputList(n);

            m = sc.nextInt();
            Node head2 = inputList(m);

            Sol obj = new Sol();

            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
    public static Node findUnion(Node head1,Node head2)
    {
        // TreeSet is storing unique elements with acesending order
        TreeSet<Integer> ts = new TreeSet<>();
        Node h1 = head1;
        Node h2 = head2;

        // put
        while(h1 != null){
            ts.add(h1.data);
            h1 = h1.next;
        }

        while(h2 != null){
            ts.add(h2.data);
            h2 = h2.next;
        }

        Node dummy = new Node(-1);
        Node curr = dummy;
        for (int val : ts) {
            Node nn = new Node(val);
            curr.next = nn;
            curr = curr.next;
        }

        return dummy.next;
    }
}