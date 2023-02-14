import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while(startCol <= endCol && startRow <= endRow){
            // top border
            for(int j = startCol; j <= endCol; j++){
                list.add(matrix[startRow][j]);
            }

            // right border
            for(int i = startRow + 1; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }

            // bottom border
            for(int j = endCol - 1; j >= startCol; j--){
                if(startRow == endRow) break;
                list.add(matrix[endRow][j]);
            }

            // left border
            for(int i = endRow - 1; i >= startRow + 1; i--){
                if(startCol == endCol) break;
                list.add(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return list;
    }
}