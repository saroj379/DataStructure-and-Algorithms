import java.util.Scanner;

public class PatternJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;

//        1
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==1 || j==1 || i==n || j==n){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

//        2
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int k=1;k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }

//        3
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

//        4
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

//        5
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

//        6
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print("");
            }
            System.out.println();
        }

//        7 -> floyd's triangle
        int k =1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }

//        8
        for(int i=1; i<=n;i++){
            for(int j =1; j<=i; j++){
                if((i+j)%2==0) {
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }

//        9--> Butterfly pattern
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(" * ");
            }
            int spaces=2*(n-i);
            for(int j=1; j<=spaces;j++){
                System.out.print("   ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i;j++){
                System.out.print( " * ");
            }
            int spaces= 2*(n-i);
            for(int j=1; j<=spaces; j++){
                System.out.print("   ");
            }
            for(int j=1;j<=i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

//        10 --> solid rhombus
        for(int i=1; i<=n; i++){
            for(int j=n-i;j>=1; j--){
                System.out.print("  ");
            }
            for(int j=1; j<=n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

//        11
        for(int i=1; i<=n; i++){
            for(int j=n-i;j>=1;j--){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }

//        12->palindrom num pattern
        for(int i=1; i<=n; i++){
            for( k=n-i; k>=1; k--){
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            for(int j=2; j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

//        13->diamond pattern
        for(int i=1; i<=n; i++){
            for(int j=n-i; j>=1; j--){
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n;i>=1; i--){
            for(int j=n-i; j>=1; j--){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

//        14->left arrow
        for(int i=1; i<=n; i++){
            for(int j=n-i; j>=1; j--){
                System.out.print("   ");
            }
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n;i>=1; i--){
            for(int j=n-i; j>=1; j--){
                System.out.print("   ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}