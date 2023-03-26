import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        reverseArray(nums, 0, n-1);

        for (int i=0; i < n; i++)
            System.out.print(nums[i] + " ");
        System.out.println("");
    }

    public static void reverseArray(int arr[], int start, int end)
    {
        // base case
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // ++start is due to we are updating the value first then puting into it
            reverseArray(arr, ++start, --end);
        }
    }
}