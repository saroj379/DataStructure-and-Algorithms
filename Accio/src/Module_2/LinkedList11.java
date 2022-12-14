package Module_2;

import java.util.Scanner;
import java.lang.*;

public class LinkedList11 {


        public static void main (String[] args) throws java.lang.Exception
        {
            LinkedList_ ll  = new LinkedList_();
            Scanner sc = new Scanner(System.in);
//        int input  = sc.nextInt();
//        for(int i=0; i<input; i++){
//            ll.addLast(sc.nextInt());
//        }
//        int k = sc.nextInt();
//        ll.deleteNode(k);
        ll.addLast(20);
//        ll.printList();
        ll.addLast(21);
        ll.addFirst(15);
        ll.addLast(30);
        ll.addFirst(7);
        ll.printList();
        ll.reverseList();
        ll.printList();
        }
    }


    //As this class is present in the same module so not need to create again
//    class Node{
//        int data;
//        Node next;
//        Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }

    class LinkedList_{
        Node head;
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
                head.next = head;
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
            System.out.println();
        }

        void reverseList(){
            if(head==null || head.next==null){
                return;
            }
            Node prev = head;
            Node curr = head.next;
            while(curr!= null){
                Node next = curr.next;
                curr.next= prev;

//                update
                prev = curr;
                curr = next;
            }
            head.next = null;
            head = prev;
        }
    }

