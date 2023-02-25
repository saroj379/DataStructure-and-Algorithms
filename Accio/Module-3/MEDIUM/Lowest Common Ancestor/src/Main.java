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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
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
    static ArrayList<Node> n2r = new ArrayList<>();
    static boolean nodeToRoot(Node root, int val){
        if(root == null) return false;

        if(root.data == val) {
            n2r.add(root);
            return true;
        }

        boolean fl = nodeToRoot(root.left, val);
        if(fl == true){
            n2r.add(root);
            return true;
        }

        boolean fr = nodeToRoot(root.right, val);
        if(fr == true){
            n2r.add(root);
            return true;
        }

        return false;
    }
    public static Node findLCA(Node node,int n1,int n2) {
        n2r = new ArrayList<>();
        nodeToRoot(node, n1);
        ArrayList<Node> l1 = n2r;

        n2r = new ArrayList<>();
        nodeToRoot(node, n2);
        ArrayList<Node> l2 = n2r;

        Node lca = new Node(0);
        int i = l1.size() -1;
        int j = l2.size() -1;

        while(i >= 0 && j >= 0){
            if(l1.get(i) != l2.get(j)){
                break;
            }
            else{
                lca = l1.get(i);
                i--;
                j--;
            }
        }
        return lca;
    }
}