package Module_1;

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

class ArrayRev{
    public int arrayRev(int[] arr, int index){
        if(arr.length == index){
            return 0;
        }
        //return the sum of the array
        return arr[index] + arrayRev(arr,index+1);

        // reverse the array by recursion(calling itself)
//        System.out.print(arr[index]+" ");
    }
}

class Solution
{
    void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //Normal reversing of array
    public void reverse(int[] arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        printArray(arr);
    }

    //Reverse the array that given a position to the end(based on 0-indexing)
    //it will change from the index - [ m+1 -> arr.length-1 ].
    void reverseArray(int[] arr, int m)
    {
        int n = arr.length;
        //this loop is very much important
        for(int i = m+1; i<((n-(m+1))/2)+(m+1); i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i+m+1];
            arr[n-1-i+m+1] = temp;
        }
        printArray(arr);
    }
}


public class Array {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        //size of array
        int intputSize = sc.nextInt();
        //created obj for array
        int[] arr = new int[intputSize];

        for(int i = 0; i < intputSize; i++){
            arr[i] = sc.nextInt();
        }

        //called the reverse function
        ArrayRev rev = new ArrayRev();
        System.out.println(Arrays.toString(arr));
        System.out.println(rev.arrayRev(arr,0));
        System.out.println();

        //obj of class solution
        Solution s= new Solution();
        s.reverse(arr);//reverse

        System.out.println("This is array reversing normal and with a given position");
        int m = sc.nextInt();
        s.reverseArray(arr, m);//reverse at some given position
    }
}