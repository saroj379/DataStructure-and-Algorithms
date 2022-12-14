package Module_2;

public class Sortings {
    public static void main(String[] args) {
        int arr[]= {7,8,3,2,1};
        BubbleSort bs =new BubbleSort();
        bs.bubble(arr);
        for(int i=0;i< arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}

class BubbleSort{
    void bubble(int arr[]){
        for(int i=0; i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}

class InsertionSort{

}

class SelectionSort{

}