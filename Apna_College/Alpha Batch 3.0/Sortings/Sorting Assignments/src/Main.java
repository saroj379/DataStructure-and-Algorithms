public class Main
{

    // Bubble sort
    public static void bubbleSort(int a[]){
        for(int i = 0; i < a.length; i++){
            boolean flag = false;
            for(int j = 0; j<a.length-1-i; j++){
                if(a[j] < a[j+1]){
                    flag = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if(flag == false) break;
        }
    }


    // Insertion sort
    public static void insertionSort(int a[]){
        for(int i = 1; i < a.length; i++){
            int currEle = a[i];
            int prev = i-1;
            while(prev >= 0 && a[prev] < currEle){
                a[prev + 1] = a[prev];
                prev--;
            }
            a[prev + 1] = currEle;
        }
    }


    // Selection Sort
    public static void selectionSort(int a[]){
        for(int i = 0; i < a.length-1; i++){
            int currMax = i;
            for(int j = i+1; j < a.length; j++){
                if(a[currMax] < a[j]){
                    currMax = j;
                }
            }
            int temp = a[i];
            a[i] = a[currMax];
            a[currMax] = temp;
        }
    }


    // Count Sort
    public static void countSort(int a[]){
        int largest = Integer.MIN_VALUE;
        for(int i =0; i < a.length; i++){
            largest = Math.max(largest, a[i]);
        }

        int[] count = new int[largest+1];
        for(int i = 0; i < a.length; i++){
            count[a[i]] += 1;
        }

        // sorting
        int j =0;
        for(int i = count.length-1; i >= 0; i--){
            while(count[i] > 0){
                a[j] = i;
                j++;
                count[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        // int arr[] = {1, 2, 3, 4, 5};
        bubbleSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        insertionSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        selectionSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        countSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}