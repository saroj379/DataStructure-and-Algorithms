import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int mat[][], Pair query[]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n][m];

        // making a prefixSum matrix
        for(int i =0; i < n; i++){
            for(int j =0; j < m; j++){
                int A = mat[i][j];
                int B = j==0 ? 0 : prefix[i][j-1];
                int C = i==0 ? 0 : prefix[i-1][j];
                int D = i==0 || j==0 ? 0 : prefix[i-1][j-1];

                prefix[i][j] = A+B+C-D;
            }
        }

        // Creating a arraylist to add and print the ans at last
        List<Integer> list = new ArrayList<>();

        // for-each loop to calculate and get the range of sum on matrix
        for(Pair q : query){
            int r1 = q.row1;
            int c1 = q.col1;
            int r2 = q.row2;
            int c2 = q.col2;

            int A = prefix[r2][c2];
            int B = c1==0 ? 0 : prefix[r2][c1-1];
            int C = r1==0 ? 0 : prefix[r1-1][c2];
            int D = r1==0 || c1==0 ? 0 : prefix[r1-1][c1-1];

            int querySum = A-B-C+D;
            list.add(querySum);
        }

        return list;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
            System.out.println(x);
        sc.close();
    }
}