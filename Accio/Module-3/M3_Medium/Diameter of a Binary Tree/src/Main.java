import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;



class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.diameter(root1));
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// TC - O(N^2), SC - O(h)
class Solution {

    public static int heightOfTree(Node root){
        if(root == null) return 0;
        int ls = heightOfTree(root.left);
        int rs = heightOfTree(root.right);

        return Math.max(ls, rs) +1;
    }

    public static int diameter(Node root) {
        if(root == null) return 0;

        int maxDiaOnLeft = diameter(root.left);

        int maxDiaOnRight = diameter(root.right);

        int myDia = heightOfTree(root.left) + 1 + heightOfTree(root.right);

        return Math.max(myDia, Math.max(maxDiaOnRight, maxDiaOnLeft));
    }
}


// TC - O(N), SC - O(h)
class Solution_ {

    static class Pair{
        int height;
        int diameter;

        Pair(){
            height = 0;
            diameter = 0;
        }

        Pair(int h, int d){
            this.height = h;
            this.diameter = d;
        }
    }

    public static Pair diameter2(Node root){
        if(root == null) return new Pair();

        Pair leftPair = diameter2(root.left);
        Pair rightPair = diameter2(root.right);

        int height =  1 + Math.max(leftPair.height , rightPair.height);

        int diaThroughMe = leftPair.height + rightPair.height + 1;
        int myDia = Math.max(diaThroughMe, Math.max(leftPair.diameter, rightPair.diameter));

        return new Pair(height, myDia);
    }

    public static int diameter(Node root) {
        Pair pair = diameter2(root);
        return pair.diameter;
    }
}