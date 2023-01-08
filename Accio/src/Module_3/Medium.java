package Module_3;

import java.util.*;


class solution{

    //Asteroids Collision
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



    // Circular tour
    boolean check(int start, int p[], int d[]){
        int n = p.length;
        int currPetrol = 0, idx = start, bunks = 0;
        if(start == n) return false;
        while(bunks < n){
            currPetrol += (p[idx] - d[idx]);
            idx = (idx+1)%n;
            bunks++;
        }
        return (currPetrol >= 0);
    }
    public int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int start = 0, end = 0, currPetrol = 0;

        while(end < n){
            currPetrol += (petrol[end] - distance[end]);
            end++;
            while(currPetrol < 0){
                currPetrol -= (petrol[start] - distance[start]);
                start++;
            }
        }
        boolean ans = check(start, petrol, distance);
        if(ans == true) return start;
        return -1;
    }


    // Next Greater Elements
    public long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            ans[st.pop()] = -1;
        }
        return ans;
    }


    // Previous greater elements
    public long[] prevLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            ans[st.pop()] = -1;
        }
        return ans;
    }


    // Print bracket numbers
    public ArrayList<Integer> bracketNumber(String str){
        int n = str.length();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int c =0;
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == '('){
                c++;
                st.push(c);
                list.add(st.peek());
            }else if(ch == ')'){
                list.add(st.pop());
            }
        }
        return list;
    }


    // Sliding window
    static int[] nextGreaterElementIndex(int[] arr){
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
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
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


    // Stock span
    static int[] stockSpan(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>= 0; i--){
            if(st.size() == 0) st.push(i);
            while(st.size() > 0 && a[st.peek()] < a[i]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            ans[st.peek()] = -1;
            st.pop();
        }

        int[] span = new int[n];
        for(int i=0; i<n; i++){
            span[i] = i - ans[i];
        }
        return span;
    }



}
public class Medium {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // Circular tour
        int n = sc.nextInt();
        int p[] = new int[n];
        int d[] = new int[n];
        for(int i=0; i<n; i++) p[i] = sc.nextInt();
        for(int i=0; i<n; i++) d[i] = sc.nextInt();
        System.out.println(new solution().tour(p,d));


        // Sliding Window
        int n2 = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n2];
        for(int i = 0; i < n2; i++)
        {
            nums[i] = sc.nextInt();
        }
        solution obj = new solution();
        int[] ans=obj.SlidingWindowMaximum(n2,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
