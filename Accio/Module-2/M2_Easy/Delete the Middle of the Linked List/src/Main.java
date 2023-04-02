import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i=0; i<input; i++){
            ll.addLast(sc.nextInt());
        }
        ll.deleteNode(input/2);
        ll.printList();
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head;
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public  void deleteNode(int position){
        if(head==null){
            return;
        }
        if(head.next==null){
            return;
        }
        if(position==0){
            head.next = head;
            return;
        }
        Node temp = head;
        for(int i=0; i<position-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void printList(){
        if(head.next==null){
            System.out.println(-1);
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}

// Approacher-2
class Solution{

    int countNode(Node head, int count){
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    Node deleteMid(Node head){
        if(head.next == null || head.next.next ==null) return null;
        int mid = countNode(head, 0) / 2;
        Node temp = head;
        for(int i =0; i < mid-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}