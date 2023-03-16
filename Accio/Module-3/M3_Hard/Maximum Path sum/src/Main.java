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
    static void printInorder(Node root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s= br.readLine();
            Node root = buildTree(s);

            Solution tr=new Solution();
            int sum=tr.findMaxSum(root);
            System.out.println(sum);
        }
    }
}

class Solution
{
    class Pair{

        int maxPathSum;
        int bestPath;

        Pair(){
            this.maxPathSum = 0;
            this.bestPath = 0;
        }

        Pair(int max, int best){
            this.maxPathSum = max;
            this.bestPath = best;
        }
    }

    Pair findMaxSum2(Node node){
        // base case
        if(node == null){
            return new Pair();
        }

        Pair leftPair = findMaxSum2(node.left);
        Pair rightPair = findMaxSum2(node.right);

        int pathSumFromMe = node.data;
        // if gaining from left
        if(leftPair.bestPath > 0){
            pathSumFromMe += leftPair.bestPath;
        }

        // if gaining from right
        if(rightPair.bestPath > 0){
            pathSumFromMe += rightPair.bestPath;
        }

        return new Pair(Math.max(pathSumFromMe, Math.max(leftPair.maxPathSum,rightPair.maxPathSum)),
                Math.max(leftPair.bestPath, Math.max(rightPair.bestPath, 0)) + node.data);
    }
    int findMaxSum(Node node){
        return findMaxSum2(node).maxPathSum;
    }
}