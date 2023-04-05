
import java.util.*;
import java.io.*;

class node{
    int val;
    node next;
    node(int val){
        this.val = val;
        next = null;
    }
}

class ll{
    node head;
    void add(int val){
        node newNode = new node(val);
        newNode.next = head;
        head = newNode;
    }

    void display(){
        node current = head;
        while(current != null){
            System.out.print(current.val+ " ");
            current = current.next;
        }
        System.out.println("");
    }
}

class Solution{
    public static void combine(node head, ll list){
        int carry = 1;
        while(head != null){
            int ans = head.val + carry;
            carry=ans/10;
            ans=ans%10;
            list.add(ans);
            head = head.next;
        }
        if(carry==1) list.add(1);
    }

    public static node reverse(node head){
        node curr = head;
        node prev = null;
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prev;
            //Updating
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public static void add1(int x){
        ll list = new ll();
        if(x==0){
            System.out.println("1");
        }
        else{
            int temp = 0;
            while(x!=0){
                temp = x%10;
                list.add(temp);

                x = x/10;
            }
            list.head=reverse(list.head);
            ll ans = new ll();
            combine(list.head, ans);
            ans.display();
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution ob = new Solution();
        ob.add1(x);
    }
}