import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    static void serialize2(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");

        serialize2(root.left, sb);
        serialize2(root.right, sb);
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serialize2(root, sb);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static int idx =0;
    static TreeNode deserialize2(String[] arr){
        if(idx == arr.length){
            return null;
        }

        if(arr[idx].equals("null")){
            idx++;
            return null;
        }

        // to change string to int
        int val = Integer.parseInt(arr[idx]);
        idx++;
        TreeNode root = new TreeNode(val);

        // create a node and make the left and right even
        root.left = deserialize2(arr);
        root.right = deserialize2(arr);

        return root;
    }
    public static TreeNode deserialize(String str) {
        String[] arr = str.split(",");
        return deserialize2(arr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}