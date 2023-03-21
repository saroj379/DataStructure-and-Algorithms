import java.util.*;

public class Main {

    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    // function to construct a BST from
    // its level order traversal
    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) root.left =
                LevelOrder(root.left, data); else root.right =
                LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0) return null;
        Node root = null;

        for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

        return root;
    }

    public static int heightOfTree(Node root){
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(Node root) {
        // if the root is null so this is balanced
        if(root == null) return true;
        // is my left sub-tree balanced
        boolean leftBalanced = isBalanced(root.left);
        // is my right sub-tree balanced
        boolean rightBalanced = isBalanced(root.right);

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        boolean isNodeBalanced = Math.abs(lh-rh) <= 1 ? true : false;
        if(leftBalanced && rightBalanced && isNodeBalanced){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        if (isBalanced(root)) System.out.println("true"); else System.out.println(
                "false"
        );
    }
}

class Node {

    int data;
    Node left, right;
}