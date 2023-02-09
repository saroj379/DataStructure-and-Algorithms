public class Main {
    public static int[] leftMax(int height[]){
        int n = height.length;
        int prefix[] = new int[n];
        prefix[0] = height[0];
        for(int  i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        return prefix;
    }

    public static int[] rightMax(int height[]){
        int n = height.length;
        int postfix[] = new int[n];
        postfix[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            postfix[i] = Math.max(postfix[i + 1], height[i]);
        }
        return postfix;
    }
    public static void main(String[] args) {
        int height[] = {2, 4, 1, 7, 4, 0, 9, 2, 4};

        int[] leftMax = leftMax(height);
        int[] rightMax = rightMax(height);

        int tappedWater = 0;
        for(int i = 0; i < height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            tappedWater += waterLevel - height[i];
        }
        System.out.println(tappedWater);
    }
}