public class Main {
    public static void spiralMatrix(int[][] matrix){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while(startCol <= endCol && startRow <= endRow){
            // top border
            for(int j = startCol; j <= endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            // right border
            for(int i = startRow + 1; i <= endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom border
            for(int j = endCol - 1; j >= startCol; j--){
                if(startRow == endRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }

            // left border
            for(int i = endRow - 1; i >= startRow + 1; i--){
                if(startCol == endCol) break;
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10 , 11, 12}
                };
        spiralMatrix(mat);
    }
}