//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[n][m];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++ )
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.findK(arr, n, m, k));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{

    public int findK(int matrix[][], int n, int m, int k)
    {
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = m - 1;
        while(startCol <= endCol && startRow <= endRow && k > 0){
            // top border
            for(int j = startCol; j <= endCol; j++){
                k--;
                if(k == 0){
                    return matrix[startRow][j];
                }
            }

            // right border
            for(int i = startRow + 1; i <= endRow; i++){
                k--;
                if(k == 0){
                    return matrix[i][endCol];
                }
            }

            // bottom border
            for(int j = endCol - 1; j >= startCol; j--){
                if(startRow == endRow) break;
                k--;
                if(k == 0){
                    return matrix[endRow][j];
                }
            }

            // left border
            for(int i = endRow - 1; i >= startRow + 1; i--){
                if(startCol == endCol) break;
                k--;
                if(k == 0){
                    return matrix[i][startCol];
                }
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return 2;
    }
}