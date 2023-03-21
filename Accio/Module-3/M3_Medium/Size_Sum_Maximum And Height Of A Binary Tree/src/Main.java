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
        System.out.println(g.sizeOfTree(root1));
        System.out.println(g.sumOfTree(root1));
        System.out.println(g.maxOfTree(root1));
        System.out.println(g.heightOfTree(root1));
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


class Solution {
    public int sizeOfTree(Node root) {
        if(root == null) return 0;

        // count the left side
        int ls = sizeOfTree(root.left);

        // count the right side
        int rs = sizeOfTree(root.left);

        // include this iteam also
        return ls+rs+1;
    }

    public int sumOfTree(Node root) {
        if(root == null) return 0;

        // sum of left elements
        int left_sum = sumOfTree(root.left);

        // sum of right elements
        int right_sum = sumOfTree(root.right);

        // add the root elements
        return root.data + left_sum + right_sum;
    }

    public int maxOfTree(Node root) {
        if(root == null)return 0;

        // left max element
        int ls = maxOfTree(root.left);

        // right max element
        int rs = maxOfTree(root.right);

        // compare left max right max and root element
        return Math.max(root.data , Math.max(ls, rs));
    }

    public int heightOfTree(Node root) {
        if(root == null) return 0;

        int ls = heightOfTree(root.left);
        int rs = heightOfTree(root.right);

        return Math.max(ls, rs) + 1;
    }
}