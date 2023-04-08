//{ Driver Code Starts
import java.util.Scanner;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}
class GFG1 {
    public static void printList(Node head)
    {
        Node start=head;
        System.out.print(head.data+" ");
        head=head.next;
        while(head!=start)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node start=null,cur=null;
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                Node ptr=new Node(a);
                if(start==null)
                {
                    start=ptr;
                    cur=ptr;
                }
                else
                {
                    cur.next=ptr;
                    cur=ptr;
                }
            }
            int delNode=sc.nextInt();
            cur.next=start;
            GFG obj=new GFG();
            Node head=obj.deleteNode(start,delNode);
            start=obj.reverse(head);
            printList(start);
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class GFG
{
    //This method returns the head of the LL after deleting node with value d.
    public static Node deleteNode(Node head,int d)
    {
        Node prev = head;
        Node curr = head.next;
        while(curr != head){
            if(curr.data == d){
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    //This method returns the head node of the reversed Linked list.
    public static Node reverse(Node head)
    {
        Node prev = head;
        Node curr = head.next;

        while(curr != head){
            // puting nxt of curr no to lost the nxt value
            Node nxtOfCurr = curr.next;

            // changeing the pointer to prev
            curr.next = prev;

            // update
            prev = curr;
            curr = nxtOfCurr;
        }
        // when the last link is there next of head to prev
        head.next = prev;
        return prev;
    }
}