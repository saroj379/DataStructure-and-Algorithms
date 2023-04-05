
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        for(int i = 0; i < m; i++){
            b.add(input.nextInt());
        }
        LinkedList ans = new LinkedList();
        Solution A = new Solution();
        ans.head = A.addTwoLinkedLists(a.head, b.head);
        ans.printList();

    }
}


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
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
}


class Solution
{
    // Reverse the List
    static Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node nxt = curr.next;
            // changing the pointer
            curr.next = prev;
            // updating
            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head;
    }

    public static Node addTwoLinkedLists(Node head1, Node head2)
    {
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node h1 = reverseList(head1);
        Node h2 = reverseList(head2);

        Node c = h1;

        int carry = 0;
        while(h1 != null && h2 != null){
            int sum = (h1.data + h2.data) + carry;
            Node nn = new Node(sum%10);
            curr.next = nn;
            curr = curr.next;

            carry = sum/10;

            h1= h1.next;
            h2 = h2.next;
        }

        while(h1 != null){
            int sum = h1.data + carry;
            Node nn = new Node(sum%10);
            curr.next = nn;
            curr = curr.next;

            carry = sum/10;

            h1= h1.next;
        }

        while(h2 != null){
            int sum = h2.data + carry;
            Node nn = new Node(sum%10);
            curr.next = nn;
            curr = curr.next;

            carry = sum/10;

            h2 = h2.next;
        }

        // if carry is greater so creating a node and add to it
        if(carry > 0){
            Node nn = new Node(carry);
            curr.next = nn;
        }

        // again reverse the final ans
        Node revAns = reverseList(dummy.next);

        return revAns;
    }
}