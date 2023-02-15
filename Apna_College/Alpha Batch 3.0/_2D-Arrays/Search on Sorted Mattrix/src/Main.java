public class Main {
    public static boolean searchOnMattrix(int[][] mat, int key){
        int row = 0, col = mat[0].length-1;
        while(row < mat.length && col >= 0){
            if(key == mat[row][col]){
                System.out.println("("+row+", "+col+")");
                return true;
            }
            else if(key < mat[row][col]){
                col--;
            }
            else row++;
        }
        System.out.println("Key not foune !");
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        int key = 1;
        System.out.println(searchOnMattrix(matrix, key));
    }
}