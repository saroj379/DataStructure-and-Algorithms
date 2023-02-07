
public class Main
{
    public static void main(String[] args) {
        int row = 4, col = 6;
        // 1- Hollow Rectangle
        for(int i=1; i <= row; i++){
            for(int j=1; j<= col; j++){
                if(i == 1 || j== col || j == 1 || i ==row){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


        // 2  Alternative 0,1's
        for(int i=1; i <= row; i++){
            for(int j=1; j<= i; j++){
                if((i+j) % 2 == 0){
                    System.out.print(1 +" ");
                }
                else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }


        // 3 Butterfly Pattern
        int n = 4;
        // 1st half
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Solid Rhombus
        row = 5;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= row-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= row; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Hollow Rhombus
        n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= n; j++){
                if(i == 1 || i == n || j == 1 || j == n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


        // Diamond Pattern
        n = 5;
        // 1st half
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j < 2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j < 2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // Number Pyramid
        n = 5;
        // 1st half
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j <= i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}