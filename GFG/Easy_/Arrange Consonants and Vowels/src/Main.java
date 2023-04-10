//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Node head = null, tail = null;

            char head_c = sc.next().charAt(0);
            head = new Node(head_c);
            tail = head;

            while(n-- > 1){
                tail.next = new Node(sc.next().charAt(0));
                tail = tail.next;
            }

            Solution obj = new Solution();
            //show(head);
            show(obj.arrangeCV(head));

        }
    }

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
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;

    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {

    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node curr=head ;
        Node vow = new Node('a');
        Node t1=vow;
        Node con = new Node('a');
        Node t2=con;

        while(curr != null)
        {
            if(curr.data =='a' || curr.data =='e' || curr.data =='i' || curr.data =='o' ||curr.data =='u')
            //if there are vowels storing them in ll;
            {
                Node t = new Node(curr.data);
                t1.next=t;
                t1=t1.next;
                curr=curr.next;

            }
            else
            {
                //if it is not vowel storing into another ll
                Node t = new Node(curr.data);
                t2.next=t;
                t2=t2.next;
                curr=curr.next;

            }
        }
        //while loop ends means ll are finished
        //now we eii joined our both ll
        t1.next=con.next;
        return vow.next;
    }
}