package Module_3;
import java.util.*;

class Node{
    int data;
    Node link;
    Node(int data){
        this.data = data;
        this.link = null;
    }
}


//this is the approach to ->Stack using LinkedList...
class StackUsingLinkedlist {

    Node top;
    StackUsingLinkedlist() { this.top = null; }
    public void push(int x)
    {
        Node newNode = new Node(x);
        if(top == null){
            top = newNode;
            return;
        }
        newNode.link = top;
        top = newNode;
    }

    public int peek()
    {
        if(top ==null) return -1;
        return top.data;
    }

    public void pop()
    {
        if(top == null){
            return;
        }
        top =top.link;
    }

    public Node display()
    {
        return top;
    }
}


public class stack_Queue_LinkedList {
    public static void main(String[] args) {
        StackUsingLinkedlist sql = new StackUsingLinkedlist();
        //we can call here by calling the required function
    }
}
