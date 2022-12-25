/*
All Solution in dictionary sequence...
Total problems :- 3
 */

import java.util.*;
import java.io.*;
import java.util.Stack;

class solution{

    // Asteroids Collision
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(asteroids[i] > 0) st.push(asteroids[i]);
            else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(st.size() > 0 && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(st.size() ==0 || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }
        }

        int[] ans = new int[st.size()];
        for(int i = st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }


    // Rotten Orange
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        if(fresh == 0) return 0;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int time =0;
        while(q.size() > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] indicies = q.remove();
                int r = indicies[0];
                int c = indicies[1];

                for(int j=0; j<4; j++){
                    int nr = r + dirs[j][0];
                    int nc = c + dirs[j][1];
                    if(nr >=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc] == 1){
                        fresh --;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }

        if(fresh == 0) return time-1;
        return -1;
    }


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