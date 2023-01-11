package Module_3;

class soultion{
    // Trapping Rain Water
    public int[] leftMaxtElement(int[] arr, int n){
        int[] l_max = new int[n];
        l_max[0] = arr[0];
        for(int i=1; i<n; i++){
            l_max[i] = Math.max(l_max[i-1], arr[i]);
        }
        return l_max;
    }

    public int[] rightMaxtElement(int[] arr, int n){
        int[] r_max = new int[n];
        r_max[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            r_max[i] = Math.max(r_max[i+1], arr[i]);
        }
        return r_max;
    }

    public void TappingWater(int[] arr, int n) {
        int[] l_max = leftMaxtElement(arr, n);
        int[] r_max = rightMaxtElement(arr, n);

        int tot_water = 0;
        for(int i=0; i<n; i++){
            tot_water += Math.min(l_max[i], r_max[i]) - arr[i];
        }
        System.out.print(tot_water);
    }
}
public class Hard {
    public static void main(String[] args) {

    }
}
