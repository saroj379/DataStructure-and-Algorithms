import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }

        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(root);
        while(qu.size() > 0){
            int size = qu.size();
            int leftMostVal = -1;
            while(size-->0){
                Node rnode = qu.remove();
                if(leftMostVal == -1){
                    leftMostVal = rnode.val;
                }

                if(rnode.left != null) qu.add(rnode.left);
                if(rnode.right != null) qu.add(rnode.right);
            }
            System.out.print(leftMostVal+" ");
        }
    }

}