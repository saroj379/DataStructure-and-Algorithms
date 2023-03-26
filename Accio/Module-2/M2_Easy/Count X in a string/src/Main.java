import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(countX(str));
    }
    static int countX(String s){
        if(s.length() <= 0){
            return 0;
        }
        else if(s.charAt(0) == 'x'){
            return 1 + countX(s.substring(1));
        }
        return countX(s.substring(1));
    }
}