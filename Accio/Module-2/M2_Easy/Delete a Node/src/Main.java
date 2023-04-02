import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        LinkedList ll  = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int input  = sc.nextInt();
        for(int i=0; i<input; i++){
            ll.addLast(sc.nextInt());
        }
        int k = sc.nextInt();
        ll.deleteNode(k);
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
    Node  head;
    // Node newNode = new Node(data);

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteNode(int position){

        if(head==null){
            return;
        }
        if(position==0){
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i =0;  i < position-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// Approaches-2
class Sol{
    public static void remove_(LinkedList ll, int toRemove){

        if(toRemove == 0){
            ll.head = ll.head.next;
            return;
        }
        Node temp = ll.head;
        int c = 0;
        while(c != toRemove-1 && temp != null){
            temp = temp.next;
            c++;
        }
        temp.next = temp.next.next;
    }
}
