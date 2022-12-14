package Module_2;

import java.util.Scanner;

class LL12{
    Node head;
//    Add element at the last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

//    Add element at first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

//    Reverse the list
    public void reverse(){
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prev;
            // update
            prev = curr;
            curr = nxt;
        }
        head.next = null;
        head = prev;
    }

//    Remove an item/element
    public void removeItem(int position){
        if(head==null){
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

//    To print and show the linkedlist
    public void printList(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    }

class LL1{
    public static void main(String[] args) {
        LL12 l = new LL12();
        Scanner sc = new Scanner(System.in);
        System.out.print("No of element that you need to add Last: ");
        int n = sc.nextInt();
        System.out.println("Enter your "+n+" elements to add at last: ");
        for(int i=0; i<n; i++) {
            l.addLast(sc.nextInt());
        }

        System.out.print("No of element that you need to add First: ");
        int m = sc.nextInt();
        System.out.println("Enter your "+m+" elements to add at last: ");
        for(int i=0; i<m; i++) {
            l.addFirst(sc.nextInt());
        }

//        How see the final list after performing the funs
        l.printList();
        l.reverse();//reversing the list
        l.printList();

        System.out.println("Which node you want to remove: ");
        l.removeItem(sc.nextInt());
        l.printList();//after removing an item

    }
}