import java.util.*;

class Node {

    int data;
    Node left, right;
}

class Solution{
    static ArrayList<Integer> treeBoundary;

    static void leftBoundary(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        else treeBoundary.add(node.data);

        if(node.left != null){
            leftBoundary(node.left);
        }else{
            leftBoundary(node.left);
        }
    }

    static void leafeBoundary(Node node){
        if(node == null) return;
        if(node.left == null && node.right == null) treeBoundary.add(node.data);
        leafeBoundary(node.left);
        leafeBoundary(node.right);
    }

    static void rightBoundary(Node node){
        if(node == null) return;
        if(node.right != null){
            rightBoundary(node.right);
        }else{
            rightBoundary(node.left);
        }

        if(node.left == null && node.right == null) return;
        else treeBoundary.add(node.data);
    }

    static void printBoundary(Node node)
    {
        treeBoundary = new ArrayList<>();
        treeBoundary.add(node.data);
        leftBoundary(node.left);
        if(node.left == null && node.right== null) return;
        leafeBoundary(node);
        rightBoundary(node.right);

        for(int i=0; i<treeBoundary.size(); i++){
            System.out.print(treeBoundary.get(i)+" ");
        }
    }
}
public class Main {

    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        Solution.printBoundary(root);
    }
}
