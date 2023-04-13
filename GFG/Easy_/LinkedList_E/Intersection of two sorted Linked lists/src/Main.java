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
            m = sc.nextInt();

            Node head1 = inputList(n);
            Node head2 = inputList(m);

            Sol obj = new Sol();

            Node result = obj.findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // created a dummy node and pointer on dummy
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null){
            // check are they same
            if(temp1.data == temp2.data){
                curr.next = temp1;
                curr = temp1;

                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            // if not same then check for greater then as they are sorted
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            else{
                temp2 = temp2.next;
            }
        }
        // now i don't need temp1 any longer so make it's next to null
        curr.next = null;

        return dummy.next;
    }
}