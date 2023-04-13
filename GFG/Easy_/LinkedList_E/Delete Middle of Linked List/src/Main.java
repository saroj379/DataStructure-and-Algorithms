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
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head);
            t--;
        }
    }
}


// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {

    // Approache-1
    int getLen(Node head, int c){
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            c++;
        }
        return c;
    }
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head == null) return null;

        int len = getLen(head, 0) / 2;

        Node temp = head;
        while(len > 1){
            temp = temp.next;
            len--;
        }
        temp.next = temp.next.next;

        return head;
    }

    // Approache-2
    Node deleteMid_(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head == null) return null;
        Node slow = head;
        Node fast = head;

        // to get prev node
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }
}