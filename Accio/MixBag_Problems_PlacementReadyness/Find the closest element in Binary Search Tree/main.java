import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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


class Main {
	static Node buildTree(String str) {
		// System.out.print(str);
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
			if (i >= ip.length)
				break;
			currVal = ip[i];
			if (!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
			i++;
		}
		return root;
	}

	static void printLevelOrder(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/* poll() removes the present head.
			For more information on poll() visit
			http://www.tutorialspoint.com/java/
			util/linkedlist_poll.htm */
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/*Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/*Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}


	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		//System.out.print(s);
		Node root = buildTree(s);
		int k;
		k = sc.nextInt();
		Solution tree = new Solution();
		int answer = tree.maxDiff(root,k);
		System.out.println(answer);
	}
}



class Solution { 
	static void minDifference(Node root, int k, int[] min_diff_key){
		
		if(root == null) return;
		// System.out.println("root is --->"+root.data);
		// if same as target then minKey would be this root value
		if(root.data == k){
			min_diff_key[0] = root.data;
			return;
		}
		// if the min_diff is greater than the abs(rootValue - k), then only update
		if(min_diff_key[1] > Math.abs(root.data - k)){
			// System.out.println("min key -> ("+min_diff_key[0]+", "+min_diff_key[1]+")");
			min_diff_key[1] = Math.abs(root.data - k);
			min_diff_key[0] = root.data;
			System.out.println("After update, min key -> ("+min_diff_key[0]+", "+min_diff_key[1]+")");
		}

		//if the taget is greater than root then go for right
		if(k > root.data) {System.out.println("root is --->"+root.data);minDifference(root.right, k, min_diff_key);}
		// else go for left
		else minDifference(root.left, k, min_diff_key);
	}
	
	static int maxDiff(Node root, int k)
	{
		int[] min_diff_key = new int[2];
		//0->key, 1->diffValue
		min_diff_key[0] = -1;
		min_diff_key[1] = Integer.MAX_VALUE;
		
		minDifference(root, k, min_diff_key);

		return min_diff_key[0];
	}
}