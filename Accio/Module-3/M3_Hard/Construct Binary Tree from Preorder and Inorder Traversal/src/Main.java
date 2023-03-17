import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left, right;
    Node(int key){
        data = key;
        left = right = null;
    }
}

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for(int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }

    public static void postOrdrer(Node root){
        if(root == null)
            return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}


class Solution{
    static Node constructBT(int[] in, int isi, int iei, int[] pre, int psi, int pei){
        if(isi > iei) return null;
        if(psi > pei) return null;

        Node root = new Node(pre[psi]);

        int val = pre[psi];

        int countInLeftSubTree = 0, i = isi;
        while(in[i] != val){
            countInLeftSubTree++;
            i++;
        }
        // divided the array while will lies on left sub-tree and which will on right sub-tree
        root.left = constructBT(in, isi, i-1, pre, psi+1, psi+countInLeftSubTree);
        root.right = constructBT(in, i+1, iei, pre, psi+countInLeftSubTree+1, pei);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[], int n){
        return constructBT(inorder, 0, n-1, preorder, 0, n-1);
    }
}
