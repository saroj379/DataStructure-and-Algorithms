/*
All Solution in dictionary sequence...
Total problems :- 2
 */

import java.util.*;
import java.io.*;
import java.util.Stack;

class solution{

    // Sliding Window
    public int[] nextGreaterElementIndex(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[st.peek()] < arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            ans[st.peek()] = n;
            st.pop();
        }
        return ans;
    }
    public int[] maxSlidingWindow(int[] arr, int K) {
        int N = arr.length;
        int[] nge = nextGreaterElementIndex(arr);
        int[] ans = new int[N-K+1];

        int j=0;
        for(int i=0; i<(N-K+1); i++){
            if(j<i) j=i;

            while(nge[j] < i+K){
                j = nge[j];
            }
            ans[i] = arr[j];
        }
        return ans;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        this.val = data;
        this.next = null;
    }
}


// Is Pallindrom or not
 class LL {
    ListNode head;
     void addFirst(int data){
         ListNode newNode = new ListNode(data);
         if(head == null){
             head = newNode;
             return;
         }
         newNode.next = head;
         head = newNode;
     }
    ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head;
    }
    void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    boolean checkListNode(ListNode head1, ListNode head2){
        while(head1 != null){
            if(head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }

        ListNode org = head;
        ListNode rev = reverseListNode(head);

        return true;
    }
}

public class leetCode{
    public static void main(String[] args) {
        LL l = new LL();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i=0; i<size; i++){
            l.addFirst(sc.nextInt());
        }

        System.out.println(l.isPalindrome(l.head));
    }
}