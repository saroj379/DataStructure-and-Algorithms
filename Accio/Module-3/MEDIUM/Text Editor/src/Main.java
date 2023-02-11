import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int q=sc.nextInt();
        sc.nextLine();
        TextEditor obj=new TextEditor();
        for(int i=0;i<q;i++)
        {
            // String[] s = sc.nextLine().split(" ");
            String s=sc.nextLine();
            if(s.equals("UNDO"))
            {
                obj.UNDO();
            }
            else if(s.equals("REDO"))
            {
                obj.REDO();
            }
            else if(s.equals("READ"))
            {
                obj.READ();

            }
            else
            {
                char ch=s.charAt(6);
                obj.WRITE(ch);
            }
        }
    }
}

class TextEditor{
    ArrayList<Character> list = new ArrayList<>();
    char redo ;
    public void WRITE(char X)
    {
        list.add(X);
    }

    void UNDO()
    {
        if(list.size() == 0) return;
        redo = list.remove(list.size() - 1);
    }


    void REDO()
    {
        list.add(redo);
    }

    void READ()
    {
        for(int  i =0; i < list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.print(" ");
    }

}