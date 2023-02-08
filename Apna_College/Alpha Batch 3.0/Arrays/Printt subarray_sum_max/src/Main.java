public class Main {

    // print subarray
    public static void printSubarray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int start = i;
            for(int j = i; j < arr.length; j++){
                int end = j;
                for(int k = start; k <= end; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // sum of subarrays
    public static void sumOfSubarrays(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int sum =0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                System.out.println(sum);
            }
            System.out.println();
        }
    }


    // Maximum sum of subarrays
    public static int maximumSumOfSubarray(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int start = i;
            int sum =0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum > max) max = sum;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        int[] numbers = {2, 3, 5, 7, 8, 9};
        printSubarray(numbers);
        sumOfSubarrays(numbers);
        System.out.print(maximumSumOfSubarray(numbers));
    }
}