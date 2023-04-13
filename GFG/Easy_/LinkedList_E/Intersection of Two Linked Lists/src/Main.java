//{ Driver Code Starts
//

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

            Solution obj = new Solution();

            Node result = obj.findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

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

*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        // creating a hashmap to put the head2 datas
        HashMap<Integer, Integer> hm = new HashMap<>();

        Node h2 = head2;
        // putiing into hashmap
        while(h2 != null){
            hm.put(h2.data, hm.getOrDefault(h2.data, 0) + 1);
            h2 = h2.next;
        }

        Node h1 = head1;
        // created a dummy node
        Node dummy = new Node(-1);
        Node curr = dummy;
        // check with iterating ll1 that elements are present or not
        while(h1 != null){
            // if ele present then create and link to dummy
            if(hm.containsKey(h1.data)){
                curr.next = h1;
                curr = curr.next;
            }
            h1 = h1.next;
        }
        curr.next = null;// making null after this to get ans ll

        // return dummy of next to get the ans
        return dummy.next;
    }
}