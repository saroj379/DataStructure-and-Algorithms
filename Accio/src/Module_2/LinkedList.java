package Module_2;

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LL{
    Node head;

    //Add first
    void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //AddLast
    void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    //Add at a particular index
    //get at -- 1st step to the index where we want to insert a value
    Node getAt(int index){
        Node curr = head;
        if(index < 0){
            System.out.println("Given index isnot in range");
            return null;
        }

        if(index == 0){
            return head;
        }

        for(int i=0; i< index; i++){
            if(curr == null){
                System.out.println("Given index is out Of range");
                return null;
            }
            curr = curr.next;
        }
        return curr;
    }
    void addAt(int data, int index){
        Node newNode = new Node (data);
        Node curr = getAt(index-1);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    //Remove first
    void removeFirst(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        head =  head.next;
    }

    //Remove last
    void removeLast(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        if(head.next == null){
            System.out.println("null");
        }
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

    //Remove at a particular index
    void removeAt(int index){
        int len = getLenght();
        if(index == 0){
            removeFirst();
            return;
        }

        if(index == len-1){
            removeLast();
            return;
        }

        Node curr = getAt(index-1);
        curr.next = curr.next.next;
    }

    //Find the middle node(element)
    //1 2 3 4 5 6, midElement is - 4
    Node midElement(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //1 2 3 4 5 6 , midElement is - 3
    int midElement_(){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }


    //Reverse the list
    void reverseList(){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node nextOfCurr = curr.next;

            curr.next = prev;

            //update the curr and prev with 1step forward
            prev = curr;
            curr = nextOfCurr;
        }
        head = prev;
    }

    //mergeTwoList


    
    //Divide a single list int 2 parts
    void joinTwoList(Node head){

    }

    //Joint these divided list


    //Reordered List


    //PrintList
    void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //get the length of the list
    int getLenght(){
        int count = 0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }
}

class LinkedList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LL l = new LL();

        //addin elements first
//        System.out.println("How many you want to add at first: ");
//        int f = sc.nextInt();
//        System.out.println("Enter for "+f+": ");
//
//        for(int i=0; i<f; i++){
//            l.addFirst(sc.nextInt());
//        }
//
//        //addin elements last
//        System.out.println("How many you want to add at last: ");
        int ls = sc.nextInt();
        System.out.println("Enter for "+ls+": ");

        for(int i=0; i<ls; i++){
            l.addLast(sc.nextInt());
        }
        l.printList(l.head);
        System.out.println(l.getLenght());


        System.out.println("Where you want to insert: ");
        int pos = sc.nextInt();
        System.out.println("Enter your value : ");
        int val = sc.nextInt();
        l.addAt(val, pos);
        l.printList(l.head);

        l.removeFirst();l.removeFirst();
        l.printList(l.head);

        l.removeLast();
        l.printList(l.head);
        System.out.println(l.getLenght());

        l.removeAt(0);
        l.printList(l.head);
        System.out.println(l.getLenght());

        System.out.println(l.midElement().data);
        System.out.println(l.midElement());

        l.addFirst(23);l.addFirst(41);l.addLast(37);l.addLast(94);
        l.printList(l.head);

        l.reverseList();
        l.printList(l.head);

        l.joinTwoList(l.head);
    }
}


//-----------------------------------------------------------------
/*
leetcode 143 (Reordered List)-->

//class Solution {
//    public void reorderList(ListNode head) {
//        ListNode mid = getMid(head);
//        ListNode headSecond = reverseLinkedList(mid);
//        ListNode headFirst = head;
//        if(headFirst == null){
//            return;
//        }
//        while(headFirst!= null && headSecond !=null){
//            ListNode temp = headFirst.next;
//            headFirst.next = headSecond;
//            headFirst = temp;
//
//            temp = headSecond.next;
//            headSecond.next = headFirst;
//            headSecond = temp;
//        }
//
//        if(headFirst!=null){
//            headFirst.next = null;
//        }
//    }
//
//    public ListNode reverseLinkedList(ListNode head){
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode next = current.next;
//
//        while(current != null){
//            current.next = prev;
//            prev = current;
//            current = next;
//            if(next != null){
//                next = next.next;
//            }
//        }
//
//        return prev;
//    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}


2nd approach

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find middle node
        ListNode slow = head, fast = head;
        ListNode mid = slow;

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        mid.next = null;                // free the original second half from original list
        ListNode rev = reverse(slow);   // reverse second half

        ListNode itr1 = head, itr2 = rev;

        // in place operation
        while (true) {
            ListNode temp1 = itr1.next;
            itr1.next = itr2;
            itr1 = temp1;

            ListNode temp2 = itr2.next;
            if (itr1 == null) break;

            itr2.next = itr1;
            itr2 = temp2;
        }
    }

    // reverse method
    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

// TC: O(n), SC: O(1)
 */