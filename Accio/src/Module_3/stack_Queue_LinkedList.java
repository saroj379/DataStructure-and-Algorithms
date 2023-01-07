/*
Implementations of A by using B.
      A          B
    Stack -> LinkedList;
             Two Queues;
             Arrays;
    Queue -> LinkedList;
             Two Stacks;
             Arrays;
*/
package Module_3;

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node link;
    Node(int data){
        this.data = data;
        this.link = null;
    }
}


//Implementing Stack using LinkedList...
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


//Implementing Queue using Linkedlist
class Queue {
    Node top;
    public void push(int value) {
        Node newNode = new Node(value);
        if(top == null){
            top = newNode;
            return;
        }
        Node curr = top;
        while(curr.link != null){
            curr = curr.link;
        }
        curr.link = newNode;
    }

    public int pop() {
        if(top == null) return -1;
        int frontVal = top.data;
        top = top.link;
        return frontVal;
    }

    public int front() {
        if(top == null) return -1;
        return top.data;
    }

    public int getSize() {
        int c = 0;
        Node curr = top;
        while(curr != null){
            c++;
            curr = curr.link;
        }
        return c;
    }
}


//Implementing Stack using 2-Queues
class StackQueue
{

    //Function to push an element in queue by using 2 stacks.
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

   //1st Approach: (enQueue) O(1) for delete and O(n) for add
    void Push(int x)
    {
        st1.push(x);
    }

    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        int ans = 0;
        if(st1.size() <= 0) return -1;
        else{
            //poping from stack1 to stack2 till having 1 element to return
            while(st1.size() > 1){
                st2.push(st1.pop());
            }
            ans = st1.pop();
            //giving back to stack1
            while(st2.size() > 0){
                st1.push(st2.pop());
            }
        }
        return ans;
    }


//    2nd Approach: (DeQueue) O(1) for delete and O(n) for add
    void Push_(int x)
    {
        while(st1.size() > 0){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(st2.size() > 0){
            st1.push(st2.pop());
        }
    }

    //Function to pop an element from queue by using 2 stacks.
    int Pop_()
    {
        if(st1.size() == 0) return -1;
        return st1.pop();
    }
}


//Implementing Stack using 2-Queues
//class Stack11
//{
//   //1st Approach: push/add O(1) and remove O(n)
//    Queue<Integer> qu1 = new LinkedList<>();
//    Queue<Integer> qu2 = new LinkedList<>();
//    void push(int a)
//    {
//        qu1.add(a);
//    }
//
//    int pop()
//    {
//        int ans = 0;
//        if(qu1.size() == 0) return -1;
//        else{
//            while(qu1.size() > 1){
//                qu2.add(qu1.remove());
//            }
//            ans = qu1.remove();
//
//            while(qu2.size() > 0){
//                qu1.add(qu2.remove());
//            }
//        }
//        return ans;
//    }


//    //2nd Approach: remove is O(1) and add is O(n)
//    void push_(int a)
//    {
//        //1. check wherethere the queue1 is empty or not, if empty the add 1st element
//        if(qu1.size() == 0) qu1.add(a);
//
//        else{
//            //2. moving queue1 elements to queue 2
//            while(qu1.size() > 0){
//                qu2.add(qu1.remove());
//            }
//            //3. add that element to after moving all elements to queue1
//            qu1.add(a);
//
//            //4. moving back to queue1
//            while(qu2.size() > 0){
//                qu1.add(qu2.remove());
//            }
//        }
//    }
//
//    int pop_()
//    {
//        if(qu1.size() <= 0) return -1;
//        return qu1.peek();
//    }
//}


//Implementing Array using 2-Queues
class twoStacks {
    int[] arr;
    int size;
    int top1, top2;

    // Constructor
    twoStacks(int n)
    {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = (size / 2) - 1;
    }

    // Method to push an element x to stack1
    void push1(int x)
    {
        //check overflow condition
        //if it will exceed the limit then we have to return
        if(top1 == (size/2)-1) return;
        top1++;
        arr[top1] = x;
    }

    // Method to push an element
    // x to stack2
    void push2(int x)
    {
        //Also check for the 2nd array
        if(top2 == size-1) return;
        top2++;
        arr[top2] = x;
    }

    // Method to pop an element from first stack
    void pop1()
    {
        //check for underflow conditions, like if there is no elements then it will not possible to remove
        if(top1 == -1){
            System.out.println(-1);
            return;
        }

        System.out.println(arr[top1]);
        top1 --;
    }

    // Method to pop an element
    // from second stack
    void pop2()
    {
        //Also here check for overflow condition
        if(top2 == (size/2)-1){
            System.out.println(-1);
            return;
        }
        System.out.println(arr[top2]);
        top2 --;
    }
}


//Main Functions(where we can create an object of class and call the required functions
public class stack_Queue_LinkedList {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        StackUsingLinkedlist obj = new StackUsingLinkedlist();
        int q1;
        q1 = sc.nextInt();
        while(q1 --> 0){
            int x;
            x = sc.nextInt();
            if(x==1){
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if(x==2){
                System.out.println(obj.peek());
            }
            if(x==3){
                obj.pop();
            }
            if(x==4){
                Node temp = obj.display();
                while (temp != null) {

                    System.out.print(temp.data+" ");

                    temp = temp.link;
                }
                System.out.println();
            }
        }


        // Queue using Linkedlist
        Queue qu = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                qu.push(x);
            }
            else if(op == 2) {
                System.out.println(qu.pop());
            }
            else if(op == 3)
                System.out.println(qu.front());
            else if(op == 4)
                System.out.println(qu.getSize());
        }


        // The Queue using 2-Stacks.
        StackQueue s = new StackQueue();
        int q2 = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q2 > 0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
                ans.add(s.Pop());
            q2--;
        }
        for(int x:ans)
            System.out.print(x+" ");
        System.out.println();

        //Functions for 2nd approach
        while(q2 > 0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push_(a);
            }
            else if(QueryType == 2)
                ans.add(s.Pop_());
            q2--;
        }
        for(int x:ans)
            System.out.print(x+" ");
        System.out.println();


        //The Stack using 2-Queues
        //1st approach
        Stack g = new Stack();
        int q3 = sc.nextInt();
        while(q3>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                g.push(a);
            }
            else if(QueryType == 2){
                System.out.print(g.pop()+" ");
            }
            q3--;
        }

        //Functions for 2nd approach
//        while(q3>0)
//        {
//            int QueryType = sc.nextInt();
//            if(QueryType == 1){
//                int a = sc.nextInt();
//                g.push_(a);
//            }
//            else if(QueryType == 2){
//                System.out.print(g.pop_()+" ");
//            }
//            q3--;
//        }


        //Array using 1-Queues
        twoStacks ts = new twoStacks(50);
        int n2;
        n2 = sc.nextInt();
        for(int i =0; i<n2; i++){
            int temp;
            temp = sc.nextInt();
            if(temp == 1) ts.pop1();
            else if(temp==3) ts.pop2();
            else if(temp == 2) {
                int temp2;
                temp2 = sc.nextInt();
                ts.push1(temp2);
            }
            else{
                int temp2;
                temp2 = sc.nextInt();
                ts.push2(temp2);
            }
        }
    }
}