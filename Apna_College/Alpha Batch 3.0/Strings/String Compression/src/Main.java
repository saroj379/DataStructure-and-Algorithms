public class Main {
    public static String strCompress(String str){
        String s = "";
        for(int i = 0; i < str.length(); i++){
            int count = 0;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count ++;
                i++;
            }
            s += str.charAt(i);
            if(count > 1){
                s += count;
            }
        }

        return s;
    }


    // Using StringBuilder
    public static String strCompressUsingSB(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length(); i++){
            int count = 0;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count ++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abccddddef";
        System.out.println(strCompress(s));
        System.out.println(strCompressUsingSB(s));
    }
}