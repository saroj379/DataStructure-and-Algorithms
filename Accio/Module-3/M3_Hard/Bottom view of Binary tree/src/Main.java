
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
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
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
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
                System.out.print(num+" ");

            System.out.println();
        }
    }
}



class Solution{
    int minPos = 0, maxPos = 0;
    void widthOfTree(Node root, int pos){
        if(root == null) return;

        widthOfTree(root.left, pos-1);
        widthOfTree(root.right, pos+1);

        minPos = Math.min(pos, minPos);
        maxPos = Math.max(pos, maxPos);
    }

    class Pair{
        Node node;
        int pos;

        Pair(Node node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        widthOfTree(root, 0);
        int width = maxPos - minPos;
        int levels = width + 1;

        ArrayList<Integer> bv = new ArrayList<>();
        if(root == null){
            return bv;
        }
        for(int i=0; i < levels; i++){
            bv.add(0);
        }

        Queue<Pair> qu = new ArrayDeque<>();
        qu.add(new Pair(root, -minPos));

        while(qu.size() > 0){
            int size = qu.size();
            while(size-->0){
                Pair rpair = qu.remove();
                bv.set(rpair.pos, rpair.node.data);

                if(rpair.node.left != null){
                    qu.add(new Pair(rpair.node.left, rpair.pos-1));
                }
                if(rpair.node.right != null){
                    qu.add(new Pair(rpair.node.right, rpair.pos+1));
                }
            }
        }
        return bv;
    }
}
