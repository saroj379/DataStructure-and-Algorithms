class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int ans[] = new int[1005];
        for(int[] trip : trips){
            int numberOfPropple = trip[0];
            int sp = trip[1];
            int ep = trip[2];

            ans[sp] += numberOfPropple;
            ans[ep] -= numberOfPropple;
        }

        for(int i=1; i< 1005; i++){
            ans[i] += ans[i-1];
        }

        for(int i=0; i<1005; i++){
            if(ans[i] > capacity){
                return false;
            }
        }

        return true;
    }
}