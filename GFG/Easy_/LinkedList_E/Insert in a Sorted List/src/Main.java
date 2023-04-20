//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
class GFG{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            int k = sc.nextInt();

            Solution g = new Solution();
            head = g.sortedInsert(head,k);

            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        Node nn = new Node(key);

        if(head1 == null || head1.data > key){
            nn.next = head1;
            head1 = nn;
            return head1;
        }


        Node curr = head1;

        while(curr.next != null && curr.next.data < key){
            curr = curr.next;
        }
        nn.next = curr.next;
        curr.next = nn;

        return head1;
    }
}