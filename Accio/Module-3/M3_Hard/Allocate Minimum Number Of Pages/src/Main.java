import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // check for the pages is saficient for B students or not
    public static boolean isDistributedSuccessively(int[] A, int B, long capacity){
        long numberOfStudents = 1, pageToThisCapacity = 0;
        for(int i = 0; i < A.length; i++){
            if(pageToThisCapacity + A[i] <= capacity){
                pageToThisCapacity += A[i];
            }else{
                numberOfStudents ++;
                pageToThisCapacity = A[i];
            }
        }
        return numberOfStudents <= B;
    }
    public long MinimumPages(int[] A, int B) {
        // if single book is not sufficient for each Student
        if(A.length < B){
            return -1;
        }
        long minPages = Integer.MIN_VALUE;
        long maxPages = 0;
        for(int i = 0; i < A.length; i++){
            minPages = Math.max(minPages, A[i]);
            maxPages += A[i];
        }
        long potentialPages = 0;
        while(minPages <= maxPages){
            long capacity = (minPages + maxPages) / 2;
            if(isDistributedSuccessively(A, B, capacity)){
                potentialPages = capacity;
                maxPages = capacity - 1;
            }else{
                minPages = capacity + 1;
            }
        }

        return potentialPages;
    }
}

class Main {


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A,B));
    }
}