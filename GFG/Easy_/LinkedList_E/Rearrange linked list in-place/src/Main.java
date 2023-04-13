//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rerrange
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for(int i = 1; i < n; i++)
            {
                int data = sc.nextInt();
                addToTheLast(new Node(data));
            }
            GfG gfg = new GfG();
            Node node = gfg.rearrange(head);
            printList(node);
            System.out.println();
        }
    }

    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}


// } Driver Code Ends


/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class GfG
{
    static Node reverse(Node head){
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

    static Node midNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node rearrange(Node root)
    {
        if(root == null) return null;
        Node mid = midNode(root);
        Node root2 = mid.next;
        mid.next = null;

        // reverse the 2nd part
        root2 = reverse(root2);

        Node c1 = root;
        Node c2 = root2;

        while(c1 != null && c2 != null){
            Node nxtOfc1 = c1.next;
            Node nxtOfc2 = c2.next;

            c1.next = c2;
            c2.next = nxtOfc1;

            c1 = nxtOfc1;
            c2 = nxtOfc2;
        }

        return root;
    }
}