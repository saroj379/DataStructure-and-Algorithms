import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        int row = 0, col = mat[0].length -1;
        while(row < mat.length && col >=0){
            if(mat[row][col] == x) return true;
            else if(mat[row][col] > x) col--;
            else row++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}