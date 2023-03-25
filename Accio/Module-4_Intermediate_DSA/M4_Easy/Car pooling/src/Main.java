
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] trips = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                trips[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

        Solution obj= new Solution();
        System.out.println(obj.carPooling(trips,k));
    }
}
class Solution{

    public boolean carPooling(int[][] trips, int capacity) {
        int ans[] = new int[1005];
        // set passangers on train
        for(int[] trip : trips){
            int numberOfPeople = trip[0];
            int sp = trip[1];
            int ep = trip[2];

            ans[sp] += numberOfPeople;
            ans[ep] -= numberOfPeople;
        }

        for(int i=1; i<1005; i++){
            ans[i] += ans[i-1];
        }

        // checking the trips are able to complete or not
        for(int i =0; i < 1005; i++){
            if(ans[i] > capacity) return false;
        }
        return true;
    }
}