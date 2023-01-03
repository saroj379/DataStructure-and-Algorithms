package Module_1;

import java.util.Scanner;

public class basicOfJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=2; i<=n; i++){
            int count = 0;
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count == 0) System.out.print(i+" ");
        }
    }
}
