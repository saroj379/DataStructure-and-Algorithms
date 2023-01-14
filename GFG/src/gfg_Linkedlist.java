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



}