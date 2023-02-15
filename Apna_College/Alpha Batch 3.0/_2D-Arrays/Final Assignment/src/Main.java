import java.util.*;

public class Main {
    // Count number of 7's
    public static int count7(int[] a[]){
        int count = 0;
        for(int i =0; i < a.length; i++){
            for(int j =0; j < a[0].length; j++){
                if(a[i][j] == 7){
                    count++;
                }
            }
        }
        return count;
    }


    // Print out the sum of 2nd row
    public static int sumOf2ndRow(int[][] mat){
        int sum =0;
        for(int i =0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(i == 2-1){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }


    // Transposed Mattrix
    public static void transposeMatrix(int[][] mat){
        int[][] trans = new int[mat[0].length][mat.length];
        for(int i =0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
//                trans[j][i] = mat[i][j];
                trans[i][j] = mat[j][i];
            }
            System.out.println(Arrays.toString(trans[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{4, 7, 8},{8, 8, 7}};
        System.out.println("Number 7's present in the array: "+count7(matrix));

        int[][] mat = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        System.out.println("Sum of 2nd row: "+sumOf2ndRow(mat));

        transposeMatrix(mat);
    }
}