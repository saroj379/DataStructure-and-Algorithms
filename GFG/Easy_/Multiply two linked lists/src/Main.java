//{ Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class MultiplyTwoLL{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Node head=null;
            Node phead=null;
            int n=sc.nextInt();
            while(n-->0){
                int n1=sc.nextInt();
                if(head==null)
                    head=new Node(n1);
                else{
                    addHead(head,n1);
                }
            }
            int m=sc.nextInt();
            while(m-->0){
                int n1=sc.nextInt();
                if(phead==null)
                    phead=new Node(n1);
                else{
                    addPhead(phead,n1);
                }
            }
            GfG g=new GfG();

            System.out.println(g.multiplyTwoLists(head,phead));
        }
    }
    public static void addHead(Node node,int a) {
        if (node == null)
            return;
        if(node.next==null)
            node.next=new Node(a);
        else
            addHead(node.next,a);
    }
    public static void addPhead(Node node,int a){
        if (node == null)
            return;
        if(node.next==null)
            node.next=new Node(a);
        else
            addPhead(node.next,a);
    }
}


// } Driver Code Ends


/*Node is defined as
class Node
{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
    /*You are required to complete this method */
    // to convert to a number form ll with modulo 10^9+7
    long getNum(Node head){
        long sum =0;
        Node curr = head;
        while(curr != null){
            sum = (sum * 10)%1000000007 + curr.data;
            curr = curr.next;
        }
        return sum;
    }

    public long multiplyTwoLists(Node l1,Node l2){
        long ll1 = getNum(l1);
        long ll2 = getNum(l2);
        return (ll1 *ll2)%1000000007;
    }
}