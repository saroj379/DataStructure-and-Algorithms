public class Main {
    public static String strToUppercase(String s){
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int  i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ' && i < s.length()-1){
                sb.append(s.charAt(i));
                i++;
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            else sb.append((s.charAt(i)));
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        String str = "Hello world! and i am saroj doing coding and felling jubilant.";
        System.out.println(strToUppercase(str));
    }
}