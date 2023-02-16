public class Main {
    public static float sortestPath(String path){
        int x = 0, y = 0;
        for(int  i =0; i < path.length(); i++){

            char ch = path.charAt(i);
            if(ch == 'E') x++;
            else if(ch == 'W') x--;
            else if(ch == 'N') y++;
            else y--;
        }
        int X2 = x * x;
        int Y2 = y * y;
        float srtPath = (float)Math.sqrt(X2 + Y2);
        return srtPath;
    }
    public static void main(String[] args) {

        System.out.println(sortestPath("WNEENESENNN"));
    }
}