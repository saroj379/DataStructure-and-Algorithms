//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            Node curr=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                    curr=head;
                }
                else{
                    Node temp=new Node(a);
                    temp.next=null;
                    curr.next=temp;
                    curr=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
        Node dummy0 = new Node(-1);
        Node dummy = new Node(-1);

        Node temp0 = dummy0;
        Node temp = dummy;

        // Node prev = null;
        Node curr = head;

        while(curr != null){
            Node nxtOfCurr = curr.next;
            // if data is 0 then puting into 0 ll
            if(curr.data == 0){
                curr.next = null;
                temp0.next = curr;
                temp0 = temp0.next;
            }
            // else putting into another ll
            else{
                curr.next = null;
                temp.next = curr;
                temp = temp.next;
            }
            curr = nxtOfCurr;;
        }
        temp0.next = dummy.next;

        return dummy0.next;
    }
}