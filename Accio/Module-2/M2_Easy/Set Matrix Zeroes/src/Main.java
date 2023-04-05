import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution.setMatrixZeroes(arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    static void setMatrixZeroes(int[][] mat) {
        boolean isZeroRow = false;
        boolean isZeroCol = false;
        int row = mat.length;
        int col = mat[0].length;

        // checking for first row
        for(int i=0; i<col; i++){
            if(mat[0][i] == 0){
                isZeroRow = true;
                break;
            }
        }

        // checking for first col
        for(int i=0; i<row; i++){
            if(mat[i][0] == 0){
                isZeroCol = true;
                break;
            }
        }

        // checking further excepting 1st row && col
        for(int i =1; i<row; i++){
            for(int j =1; j<col; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // making zero if col or row has
        for(int i =1; i<row; i++){
            for(int j =1; j<col; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        // if row has single zero is there then make all zero in 1sr row
        if(isZeroRow){
            for(int i =0; i<col; i++){
                mat[0][i] =0;
            }
        }
        // if col has single zero is there then make all zero in 1sr col
        if(isZeroCol){
            for(int i =0; i<row; i++){
                mat[i][0] =0;
            }
        }
    }
}