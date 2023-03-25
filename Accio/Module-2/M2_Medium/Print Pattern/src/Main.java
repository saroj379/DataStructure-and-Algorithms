import java.util.*;
import java.io.*;

class Solution{
    static void printPattern(int n, int start, boolean inc){

        // print start
        System.out.print(start+" ");

        // base case to check encounter to end
        if(n == start && inc == true){
            return;
        }

        // if inc == false
        if(!inc){
            // check st-5 is greater than 0, then repeat it so inc have to false(as usual)
            if(start-5 > 0){
                printPattern(n, start-5, false);
            }
            // once for -ve value or zero, after that make inc to true to print -ve to N again
            else{
                printPattern(n, start-5, true);
            }
        }
        // inc will true to print -ve or 0 --> N
        else{
            printPattern(n, start+5, true);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean inc = false;
        Solution.printPattern(n, n, inc);
    }
}
