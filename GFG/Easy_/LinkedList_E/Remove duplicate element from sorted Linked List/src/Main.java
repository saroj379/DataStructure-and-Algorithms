//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
class Remove_Duplicate_From_LL
{
    Node head;
    Node tail;
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            GfG g = new GfG();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }}
// } Driver Code Ends


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    int getLen(Node head, int c){
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            c++;
        }
        return c;
    }
    //Function to remove duplicates from sorted linked list.
    // TC -> O(N)
    Node removeDuplicates(Node head)
    {
        int len = getLen(head, 0);

        Node curr = head;
        Node nxt = curr.next;

        while(nxt != null){

            if(curr.data == nxt.data){
                while(curr.data == nxt.data){
                    nxt = nxt.next;
                    if(nxt == null){
                        curr.next = nxt;
                        return head;
                    }
                }
                curr.next = nxt;
                curr = nxt;
                nxt = curr.next;
            }
            else{
                curr = curr.next;
                nxt = nxt.next;
            }

        }

        return head;
    }
}
