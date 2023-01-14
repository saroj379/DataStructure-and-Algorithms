/*
LinkedList of geeks for geeks (as diction sequence)
Totall Problem :- 3
*/

//Node class for a single node while create...
class Node{
    int data;
    Node next;
    Node(int d){
        this.data = d;
        this.next = null;
    }
}
public class gfg_Linkedlist {

    // Check If Circular LinkedList
    boolean isCircular(Node head)
    {
        Node tor = head;
        Node hare = head;
        while(hare.next != null && hare.next.next != null){
            tor = tor.next;
            hare = hare.next.next;
            if(hare == tor) return true;
        }
        return false;
    }


    //Detect lope in linkedlist.
    public static boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    //Finding middle element in a linked list
    int getMiddle(Node head)
    {
        Node tor = head;
        Node hare = head;
        while(hare != null && hare.next != null){
            tor = tor.next;
            hare = hare.next.next;
        }
        return tor.data;
    }


    // Implement Stack using Linked List
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;
    void push(int a)
    {
        StackNode newNode = new StackNode(a);
        if(top == null){
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        if(top == null) return -1;
        int val = top.data;
        top=top.next;
        return val;
    }


    // Linkedlist length Even or Odd
    int isLengthEvenorOdd(Node head1)
    {
        int count =0;
        Node temp = head1;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        if(count%2==0) return 0;
        return 1;
    }


    // Print LinkedList Elements
    void display(Node head)
    {
        Node newNode = head;
        while(newNode != null){
            System.out.print(newNode.data+" ");
            newNode = newNode.next;
        }
    }

    //Remove a loop in the linked list.
    public static void removeLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                if(slow == fast){
                    while(fast.next != slow){
                        fast = fast.next;
                    }
                }else{
                    while(fast.next != slow.next){
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                fast.next = null;
            }
        }
    }


    // Reverse a linked list.
     Node reverseList(Node head)
     {
         Node curr = head;
         Node prev = null;
         while(curr != null){
             Node nxt = curr.next;
             curr.next = prev;

             prev = curr;
             curr = nxt;
         }
         head = prev;
         return head;
     }

}