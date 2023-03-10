import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    static Node treeBuilder(String str){
        if(str.length()==0 || str.charAt(0)=='-'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = treeBuilder(s);
            Solution g = new Solution();
            if(g.isBST(root))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }

}

class Solution{
    int maxValue(Node node){
        if(node == null) return Integer.MIN_VALUE;

        int value = node.data;
        int l_max = maxValue(node.left);
        int r_max = maxValue(node.right);

        return Math.max(value, Math.max(l_max, r_max));
    }

    int minValue(Node node){
        if(node == null) return Integer.MAX_VALUE;

        int value = node.data;
        int l_max = minValue(node.left);
        int r_max = minValue(node.right);

        return Math.min(value, Math.min(l_max, r_max));
    }

    boolean isBST(Node node){
        if(node == null) return true;
        // if left sub tree has greater value of node
        if(node.left != null && maxValue(node.left) > node.data) return false;

        // if right sub tree has less value of node
        if(node.right != null && minValue(node.right) < node.data) return false;

        // check for less value on left
        boolean isLBST = isBST(node.left);
        // check for big value on right
        boolean isRBST = isBST(node.right);

        return (isLBST && isRBST);

    }
}
