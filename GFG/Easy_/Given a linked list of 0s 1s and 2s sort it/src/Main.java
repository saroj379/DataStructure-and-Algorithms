//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head);
            System.out.println();
        }
    }

    public static void printList(Node head)
    {
        if(head == null)
            return;

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zeros = new Node(-1);
        Node dummy0 = zeros;
        Node ones = new Node(-1);
        Node dummy1 = ones;
        Node twos = new Node(-1);
        Node dummy2 = twos;

        Node curr = head;
        while(curr != null){
            // for 0
            if(curr.data == 0){
                Node nn = new Node(curr.data);
                dummy0.next = nn;
                dummy0 = nn;
            }
            // for 1
            if(curr.data == 1){
                Node nn = new Node(curr.data);
                dummy1.next = nn;
                dummy1 = nn;
            }
            // for 2
            if(curr.data == 2){
                Node nn = new Node(curr.data);
                dummy2.next = nn;
                dummy2 = nn;

                // curr = curr.next;
            }
            curr = curr.next;
        }

        if(zeros.next != null && ones.next != null && twos.next != null){
            dummy0.next = ones.next;
            dummy1.next = twos.next;

            return zeros.next;
        }

        if(zeros.next == null){
            // linking 1 -> 2
            dummy1.next = twos.next;
            return ones.next;
        }

        if(ones.next == null){
            // linking 0 -> 2
            dummy0.next = twos.next;
            return zeros.next;
        }

        if(twos.next == null){
            // linking 1 -> 2
            dummy0.next = ones.next;
            return zeros.next;
        }

        return zeros.next;
    }
}