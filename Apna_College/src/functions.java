import java.util.Scanner;

public class functions {
    public static void main(String[] args) {
        //String builders
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        System.out.println(sb);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('s');
        sb2.append('a');
        sb2.append('r');
        sb2.append('o');
        sb2.append('j');
        System.out.println(sb2);
        sb.insert(0, 'k');
        System.out.println(sb);
        sb2.insert(3, 'i');
        System.out.println(sb2);
        sb2.delete(3, 4);
        System.out.println(sb2);
        sb2.replace(1, 2, "k");
        System.out.println(sb2);
        StringBuilder sb3;
        sb3 = sb;
        System.out.println(sb3);
        sb3.setCharAt(0, 'N');
        sb3.setCharAt(1, 'x');
        System.out.println(sb3);
    }
}