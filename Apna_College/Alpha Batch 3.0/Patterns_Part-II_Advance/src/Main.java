
public class Main
{
    public static void main(String[] args) {
        int row = 4, col = 6;
        // 1- Hollow Rectangle
        for(int i=1; i <= row; i++){
            for(int j=1; j<= col; j++){
                if(i == 1 || j== col || j == 1 || i ==row){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


        // 2  Alternative 0,1's
        for(int i=1; i <= row; i++){
            for(int j=1; j<= i; j++){
                if((i+j) % 2 == 0){
                    System.out.print(1 +" ");
                }
                else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }


        // 3 Butterfly Pattern
        int n = 4;
        // 1st half
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Solid Rhombus
        row = 5;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= row-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= row; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Hollow Rhombus
        n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= n; j++){
                if(i == 1 || i == n || j == 1 || j == n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


        // Diamond Pattern
        n = 5;
        // 1st half
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j < 2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j < 2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Number Pyramid
        n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j <= i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }


        // Palindromic Pattern with Numbers
        n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =i; j >= 1; j--){
                System.out.print(j);
            }
            for(int j = 2; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        int[] numbers = {2, 3, 5, 7, 8, 9};
        printSubarray(numbers);
        sumOfSubarrays(numbers);
    }

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


}