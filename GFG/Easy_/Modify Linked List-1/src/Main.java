//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {

    public static void po(Object o){
        System.out.println(o);
    }

    public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            Node head1 = null,tail1 = null;

            int n1 = sc.nextInt();
            int d1 = sc.nextInt();
            head1 = new Node(d1);
            tail1 = head1;

            while(n1-- > 1){
                Node n = new Node(sc.nextInt());
                n.next = head1;
                head1 = n;
            }

            Solution obj = new Solution();
            head1 = obj.modify(head1);
            show(head1);
            //System.out.println();
        }
    }

}
// } Driver Code Ends


/*
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {

    // Reverse the list
    Node reverseList(Node head){
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

    // Get mid of the ll
    Node midNode(Node head){
        Node prev = null;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node modify(Node head){

        Node mid = midNode(head);
        Node head2= mid.next;
        mid.next = null;

        head2 = reverseList(head2);

        Node curr1 = head;
        Node curr2 = head2;

        // System.out.println(curr1.data+" --- "+curr2.data);
        while(curr1 != null && curr2 != null){
            curr1.data = curr1.data - curr2.data;
            curr2 = curr2.next;
            if(curr1.next != null){
                curr1 = curr1.next;
            }
        }

        head2 = reverseList(head2);
        curr1.next = head2;

        return head;
    }
}