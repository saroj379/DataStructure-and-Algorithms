import java.io.*;
import java.util.*;

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
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static Node merge(Node x, Node y){
        Node p1 = x;
        Node p2 = y;

        Node dummy = new Node(-1);
        Node curr = dummy;

        while(p1!=null && p2!=null){
            Node np1 = p1.next;
            Node np2 = p2.next;

            if(p1.data < p2.data){
                curr.next = p1;
                p1 = np1;
            }
            else{
                curr.next = p2;
                p2 = np2;
            }
            curr = curr.next;
        }
        if(p1!=null){
            curr.next = p1;
        }
        if(p2!=null){
            curr.next = p2;
        }

        return dummy.next;
    }
}

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i=0;i<m;i++){
            l2.add(sc.nextInt());
        }

        Solution Ob = new Solution();
        Node head = Ob.merge(l1.head, l2.head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}