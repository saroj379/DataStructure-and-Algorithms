//{ Driver Code Starts
//Code by:Saksham Raj Seth
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class LL{
    Node head;
    Node tail;
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            LL llist = new LL();
            llist.head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            int value=sc.nextInt();
            Node phead=head;
            while(phead.next!=null){
                phead=phead.next;
            }
            phead.next=head;
            Solution ob=new Solution();
            head = ob.sortedInsert(head,value);
            Node current = head;

            if(head != null){
                do{
                    System.out.print(current.data+" ");
                    current = current.next;
                }while(current != head);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class Solution
{
    public static Node sortedInsert(Node head,int data)
    {
        Node nn = new Node(data);
        // if head is null
        if(head == null){
            head =nn;
            return head;
        }

        Node curr = head;
        // check if the value is less then head
        if(curr.data > data){
            // make point to head
            nn.next = head;
            // then traverse through LL to connect the last link to new Node of data
            while(curr.next != head)
            {
                curr=curr.next;
            }
            // Cconnected
            curr.next=nn;
            return nn;
        }
        // if the value is about insert at between or at end
        else{
            // if element is insert in between the -> curr.next.data < data
            // if the ele will for end then curr.next != head , these two conditions to not to get null pointer exceptions
            while(curr.next.data < data && curr.next != head){
                curr = curr.next;
            }
            nn.next = curr.next;
            curr.next = nn;
        }

        return head;
    }
}