/*
CONTEXT:-(All the problems are in diction sequence) like A,B,C,...
for your reference
*/

package Arrays;

import java.util.Arrays;

class gfg_arrays {

    //Count of smellest elements
    public long countOfElements(long arr[], long n, long x)
    {
        long count =0;
        for(int i=0; i<n; i++){
            if(arr[i] <= x){
                count++;
            }
        }
        return count;
    }


    //Cyclic rotation by one
    public void rotate(int arr[], int n)
    {
        int x = arr[n-1];
        for(int i=n-1; i>=1 ;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = x;
    }


    //Find index
    static int[] findIndex(int a[], int N, int key)
    {
        //code here.
        int f_ind = -1, l_ind = -1;
        for(int i=0; i<N; i++){
            if(a[i]==key){
                if(f_ind==-1){
                    f_ind = i;
                }
                l_ind=i;
            }
        }
        int arr[] = new int[2];
        arr[0] = f_ind;
        arr[1] = l_ind;
        return arr;
    }


    //Kth element is present or not
    int binarysearch(int arr[], int n, int k) {
        int i=0; int j = n-1;
        while(i <= j){
            int mid = (i+j)/2;
            // System.out.println(mid+" "+i+" "+j);
            if(arr[mid] > k){
                j= mid-1;
            }
            else if(arr[mid] < k){
                i = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


    //Largest element in an array
    public void bubbleSort(int arr[], int n){
        boolean flag = true;
        for(int i=0; i<3; i++){
            for(int j = 0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    int largest(int arr[], int n)
    {
        bubbleSort(arr,n);
        return arr[n-1];
    }


    //Last index of 1
    public int lastIndex( String s) {
        int idx= -1;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                idx = i;
            }
        }
        return idx;
    }


    //Number of occurences
    int count(int[] arr, int n, int x) {
        if(n == 0){
            return 0;
        }
        if(arr[n-1] == x){
            return 1+count(arr, n-1, x);
        }
        return count(arr,n-1,x);
    }


    //Perfect array
    public boolean IsPerfect(int a[], int n)
    {
        int arr[] = new int[n] ;
        for(int i=0; i<n; i++){
            for(int j=n-1-i; j>=0; j--){
                arr[j] = a[i];
            }
        }
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(a[i]==arr[i]){
                // flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }


    //Print alternative element in an array
    public static void print(int arr[], int n)
    {
        for(int i=0; i<n; i++){
            if(i%2==0){
                System.out.print(arr[i]+" ");
            }
        }
    }


    //Print array
    void printArray(int arr[], int n) {
        //   code here
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //Print array using recursion
    void printArrayRec(int arr[], int n, int idx) {
        //   code here
        if(idx == n) return;

        System.out.print(arr[n-1]+" ");
        printArrayRec(arr, n, idx+1);
    }


    //Replace all 0's to 5's
    int reverseNumber(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum = sum*10 + rem;
            num/=10;
        }
        return sum;
    }
    int convertfive(int num) {
        int ans = 0;
        if(num==0){
            return 5;
        }
        else{
            int sum =0;
            while(num > 0){
                int rem = num%10;
                if(rem == 0){
                    rem = 5;
                }
                sum = sum*10+rem;
                num /= 10;
            }
            ans = reverseNumber(sum);
        }
        return ans;
    }


    //Search an element in an array
    static int search(int arr[], int N, int X)
    {

        for(int i=0; i<N; i++){
            if(arr[i] == X){
                return i;
            }
        }
        return -1;
    }


    //Second Largest Elements in array
    int print2largest(int arr[], int n) {
        // code here
        int max = Integer.MIN_VALUE, sec_max= Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        for(int i=0; i<n; i++){
            if(max != arr[i] && sec_max < arr[i]){
                sec_max = arr[i];
            }
        }
        if(sec_max == Integer.MIN_VALUE){
            return -1;
        }
        return sec_max;
    }


    //Smaller and larger
    int[] getMoreAndLess(int[] arr, int n, int x) {
        int grt_count=0, sml_count=0;
        for(int i=0; i<n; i++){
            if(arr[i]<=x){
                sml_count++;
            }
            if(arr[i]>=x){
                grt_count++;
            }
        }
        int [] res = new int[2];
        res[0] = sml_count;
        res[1] = grt_count;
        return res;
    }


    //Sum of arrays
    int sum(int arr[], int n) {
        int sum =0;
        for(int i=0; i<n; i++){
            sum +=  arr[i];
        }
        return sum;
    }


    //Swap kth elements
    void swapKth(int arr[], int n, int k) {
        int temp= 0, k1=k-1;
        for(int i=0; i<n; i++){
            if(k1==i){
                temp = arr[i];
                arr[i] = arr[n-1-i];
                arr[n-1-i] = temp;
            }
        }
    }


    //Thired largest element
    //used bubblesort function on above
    int thirdLargest(int a[], int n)
    {
        if(n < 3){
            return -1;
        }
        bubbleSort(a,n);
        return a[n-3];
    }


    //Two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<n; i++){
            if(A[i]!=B[i]){
                return false;
            }
        }
        return true;
    }
}