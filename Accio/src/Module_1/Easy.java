package Module_1;



class solution{


    // RECURSION ----------------------------------------------------------------

    // First Occurance Index of an Element
    static int firstIndex(int A[],int T,int startIndex)
    {
        int size = A.length;
        if(startIndex == size){
            return -1;
        }
        if(A[startIndex] == T){
            return startIndex;
        }
        return firstIndex(A,T,++startIndex);
    }


    // STRING----------------------------------------------------------------

    // Count and Say
    public String countandsay(int n) {
        //Write code here
        if (n == 1)   return "1";
        if (n == 2)   return "11";

        // Find n'th term by generating
        // all terms from 3 to n-1.
        // Every term is generated
        // using previous term

        // Initialize previous term
        String str = "11";
        for (int i = 3; i <= n; i++)
        {
            // In below for loop, previous
            // character is processed in
            // current iteration. That is
            // why a dummy character is
            // added to make sure that loop
            // runs one extra iteration.
            str += '$';
            int len = str.length();

            int cnt = 1; // Initialize count
            // of matching chars
            String tmp = ""; // Initialize i'th
            // term in series
            char []arr = str.toCharArray();

            // Process previous term
            // to find the next term
            for (int j = 1; j < len; j++)
            {
                // If current character
                // doesn't match
                if (arr[j] != arr[j - 1])
                {
                    // Append count of
                    // str[j-1] to temp
                    tmp += cnt;

                    // Append str[j-1]
                    tmp += arr[j - 1];

                    // Reset count
                    cnt = 1;
                }

                // If matches, then increment
                // count of matching characters
                else cnt++;
            }

            // Update str
            str = tmp;
        }
        return str;
    }
}
public class Easy {
    public static void main(String[] args) {

    }
}
