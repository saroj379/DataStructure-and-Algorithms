//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=1; i<n; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            Solution obj = new Solution();
            System.out.println(obj.sum(head, k));
        }
    }
}
// } Driver Code Ends


/*
Node class is as follows:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {

    //Return the sum of last k nodes
    int countNodes(Node head, int c){
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }

    public int sum(Node head, int k){
        //write code here
        if(head == null) return 0;
        int M = countNodes(head, 0);
        int sumOfLastN_nodes = 0;


        Node temp = head;
        for(int i=0; i<M; i++){
            if((M-k)<=i) sumOfLastN_nodes += temp.data;
            temp = temp.next;
        }

        return sumOfLastN_nodes;
    }
}