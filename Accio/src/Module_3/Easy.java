package Module_3;

import java.util.*;

class Hashmap{
    // 1st approach
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        int[] cnt = new int[1000001];
        for(int i=0; i<nums.length; i++){
            cnt[nums[i]]++;
            if(cnt[nums[i]] == k){
                System.out.print(nums[i]);
                return;
            }
        }
        System.out.print(-1);
    }

    // 2nd approach using HashMap
    public void firstElementToOccurKTimes_(int[] nums, int n, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(nums[i])){
                int oldVal = hm.get(nums[i]);
                hm.put(nums[i], oldVal+1);
            }
            else hm.put(nums[i], 1);
            if(hm.get(nums[i]) == k){
                System.out.print(nums[i]);
                return;
            }
        }
        System.out.print(-1);
    }


    // Missing elements
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        int[] cnt1 = new int[10001];
        int[] cnt2 = new int[10001];

        for(int i=0; i<n; i++) cnt1[arr[i]]++;
        for(int i=0; i<m; i++) cnt2[brr[i]]++;

        boolean found = false;
        for(int i=0; i< cnt1.length; i++){
            if(cnt1[i] != cnt2[i] && cnt2[i] > 0){
                System.out.print(i +" ");
                found = true;
            }
        }
        if(found == false) System.out.print(-1);
    }
}


public class Easy {
    // Rotten Orange
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh=0;
//        Queue<int[]> q = new LinkedList<>();
//        for(int i=0; i< rows; i++){
//            for(int j=0; j<cols; j++){
//                if(grid[i][j] == 1) fresh++;
//                else if(grid[i][j] == 2) q.add(new int[]{i,j});
//            }
//        }
//        if(fresh == 0) return 0;
//
//        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
//        int time =0;
//        while(q.size() > 0){
//            int size = q.size();
//            for(int i=0; i<size; i++){
//                int[] indicies = q.remove();
//                int r = indicies[0];
//                int c = indicies[1];
//
//                for(int j=0; j<4; j++){
//                    int nr = r + dirs[j][0];
//                    int nc = c + dirs[j][1];
//                    if(nr >=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc] == 1){
//                        fresh --;
//                        grid[nr][nc] = 2;
//                        q.add(new int[]{nr,nc});
//                    }
//                }
//            }
//            time++;
//        }
//
//        if(fresh == 0) return time-1;
        return -1;
    }


    // Find all duplicates in array
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] cnt = new int[100001];
        boolean check = false;
        for(int i=0; i<n; i++){
            cnt[arr[i]] ++;
            if(cnt[arr[i]] == 2){
                System.out.print(arr[i]+" ");
                check = true;
            }
        }
        if(check == false) System.out.print(-1);
    }
}
