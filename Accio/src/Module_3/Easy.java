package Module_3;

import java.util.*;

class Hashmap{

    // Balanced Expression
    char absChar(char c){
        if(c == ')')return '(';
        else if(c == '}')return '{';
        else if(c== ']')return '[';
        return '?';
    }

    boolean expBalanced(String str){
        int n = str.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else if(!st.empty() && (ch == ')' || ch == '}' || ch == ']')){
                if(st.peek() != absChar(ch)){
                    return false;
                }else {
                    st.pop();
                }
            }
        }
        return st.empty();
    }


    // Celebrity Problems
    int findCelebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size() >= 2){
            int p1 = st.pop();
            int p2 = st.pop();
            if(M[p1][p2] == 1)st.push(p2);
            else st.push(p1);
        }
        int celeb = st.pop();
        for(int k=0; k<n; k++){
            if(M[celeb][k] == 1) return -1;
        }
        for(int r=0; r<n; r++){
            if(r!=celeb && M[r][celeb] ==0) return -1;
        }
        return celeb;
    }


    // Design Stack Using linkedlist
    Node top;
    public void push(int x)
    {
        Node temp = new Node(x);
        if(top == null){
            top = temp;
            return;
        }
        temp.link = top;
        top = temp;
    }

    public int peek()
    {
        if(top == null)return -1;
        return top.data;
    }

    public void pop()
    {
        if(top == null) return;
        Node forward = top.link;
        top.link = null;
        top = forward;
    }

    public Node display()
    {
        return top;
    }


    // Equilibrim Index
    static int findEquilibriumIndex(int[] a) {
        int n = a.length;
        int totalSum =0;
        for(int i=0; i<n; i++) totalSum += a[i];

        int leftSum =0;
        for(int i=0; i<n; i++){
            int rightSum = totalSum - leftSum - a[i];
            if(leftSum == rightSum) return i;
            leftSum += a[i];
        }
        return -1;
    }


    // Extra brackets
    public boolean ExtraBrackets(String exp) {
        int n = exp.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = exp.charAt(i);
            if(ch != ')') st.push(ch);
            else{
                if(st.peek() == '(') return true;
                else{
                    while(st.size() > 0 && st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }
        return false;
    }


    // First element occurs K times
    // 1st approach
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        int[] cnt = new int[1000001];
        for(int i=0; i<nums.length; i++){
            cnt[nums[i]]++;
            if(cnt[nums[i]] == k){
                System.out.print(nums[i]);
                return;
            }
        }
        System.out.print(-1);
    }

    // 2nd approach using HashMap
    public void firstElementToOccurKTimes_(int[] nums, int n, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(nums[i])){
                int oldVal = hm.get(nums[i]);
                hm.put(nums[i], oldVal+1);
            }
            else hm.put(nums[i], 1);
            if(hm.get(nums[i]) == k){
                System.out.print(nums[i]);
                return;
            }
        }
        System.out.print(-1);
    }

// Implement Stack using Queue push O(1)

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


    // Largest subarray 0 sum
    public int maxLen(int arr[])
    {
        int n = arr.length;
        int maxLen = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); // Initialization
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            // check for sum in hm
            if(hm.containsKey(sum)){
                int len = i - hm.get(sum);
                maxLen = Math.max(len, maxLen);
            }
            else hm.put(sum, i);
        }
        return maxLen;
    }


    // Missing elements
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        int[] cnt1 = new int[10001];
        int[] cnt2 = new int[10001];

        for(int i=0; i<n; i++) cnt1[arr[i]]++;
        for(int i=0; i<m; i++) cnt2[brr[i]]++;

        boolean found = false;
        for(int i=0; i< cnt1.length; i++){
            if(cnt1[i] != cnt2[i] && cnt2[i] > 0){
                System.out.print(i +" ");
                found = true;
            }
        }
        if(found == false) System.out.print(-1);
    }


    // Pair Sum divisible by K
    public int sumDivbyK(int[] arr, int n, int k){
        Map <Integer, Integer> hm = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<n; i++){
            int rem = arr[i]%k;
            if(rem == 0){
                int val = hm.getOrDefault(rem, 0);
                cnt += val;
            }
            else{
                int val = hm.getOrDefault((k-rem), 0);
                cnt += val;
            }
            int oldVal = hm.getOrDefault(rem, 0);
            hm.put(rem, oldVal + 1);
            // to see how its look after pushing, do uncomment and see
            // System.out.println(hm);
        }
        return cnt;
    }


    // Problem with Given difference
    public int givenDifference(int []A, int n, int B) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(A[i] + B) || hm.containsKey(A[i] - B)){
                return 1;
            }
//            if(hm.containsKey(A[i])){
//                int oldVal = hm.get(A[i]);
//                hm.put(A[i], oldVal+1);
//            }
//            else hm.put(A[i], 1);

            // We can write this 2lines of code except the above if-else statement
            int oldVal = hm.getOrDefault(A[i], 0);
            hm.put(A[i], oldVal+1);
        }
        return 0;
    }


    // Record Values
    public int recordValues(String[] operations, int n){
        Stack<String> st = new Stack<>();
        Stack<String> ist = new Stack<>();

        for(int i=0; i < n; i++){
            String s = operations[i];
            char ch = s.charAt(0);
            if(ch == 'C'){
                st.pop();
            }else if(ch == 'D'){
                int r = Integer.parseInt(st.peek());
                r = 2*r;
                st.push(String.valueOf(r));
            }else if(ch == '+'){
                int sum =0;
                for(int k=0; k<2; k++){
                    sum += Integer.parseInt(st.peek());
                    ist.push(st.pop());
                }
                while(!ist.empty()){
                    st.push(ist.pop());
                }
                st.push(String.valueOf(sum));
            }else{
                st.push(s);
            }
        }

        int tot =0;
        while(!st.empty()){
            int r = Integer.parseInt(st.pop());
            tot += r;
        }
        return tot;
    }

    // Subarray sum divisible by K
    public static int subarraySumDivision(int arr[], int k){
        int n =  arr.length;
        int count =0, sum =0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for(int i=0; i<n; i++){
            sum += arr[i];
            int rem = sum % k;
            if(rem < 0) rem+=k;
            int oldVal = hm.getOrDefault(rem, 0);
            count += oldVal;
            hm.put(rem, oldVal+1);
        }
        return count;
    }


    // Valid Anagram
    static boolean areAnagram(String c1, String c2) {
        c1 = c1.toLowerCase();
        c2 = c2.toLowerCase();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(c1.length() != c2.length()){
            return false;
        }
        for(int i=0; i<c1.length() ; i++){
            arr1[c1.charAt(i)-'a'] ++;
            arr2[c2.charAt(i)-'a'] ++;
        }

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}


public class Easy {
    // Rotten Orange
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh=0;
//        Queue<int[]> q = new LinkedList<>();
//        for(int i=0; i< rows; i++){
//            for(int j=0; j<cols; j++){
//                if(grid[i][j] == 1) fresh++;
//                else if(grid[i][j] == 2) q.add(new int[]{i,j});
//            }
//        }
//        if(fresh == 0) return 0;
//
//        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
//        int time =0;
//        while(q.size() > 0){
//            int size = q.size();
//            for(int i=0; i<size; i++){
//                int[] indicies = q.remove();
//                int r = indicies[0];
//                int c = indicies[1];
//
//                for(int j=0; j<4; j++){
//                    int nr = r + dirs[j][0];
//                    int nc = c + dirs[j][1];
//                    if(nr >=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc] == 1){
//                        fresh --;
//                        grid[nr][nc] = 2;
//                        q.add(new int[]{nr,nc});
//                    }
//                }
//            }
//            time++;
//        }
//
//        if(fresh == 0) return time-1;
        return -1;
    }


    // Find all duplicates in array
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] cnt = new int[100001];
        boolean check = false;
        for(int i=0; i<n; i++){
            cnt[arr[i]] ++;
            if(cnt[arr[i]] == 2){
                System.out.print(arr[i]+" ");
                check = true;
            }
        }
        if(check == false) System.out.print(-1);
    }
}