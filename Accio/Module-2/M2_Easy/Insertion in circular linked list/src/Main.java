import java.util.*;
import java.io.*;

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
            head.next = head; return; }
        Node curr = head;
        while(curr.next != head) curr = curr.next;
        curr.next = new_node;
        new_node.next = head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList ll = new LinkedList();
        for(int i = 0; i < n; i++){
            ll.add(input.nextInt());
        }
        ll.add(input.nextInt());
        Node head = ll.head;
        do{
            System.out.print(head.data + " ");
            head = head.next;
        }while(head != ll.head);
    }
}