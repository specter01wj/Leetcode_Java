package com.invertBinaryTree;
import java.util.*;

/*
Given the root of a binary tree, invert the tree, and return its root.
*/

//TreeNode class
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {}
	
	TreeNode(int val) { this.val = val; }
	
	TreeNode(int val, TreeNode left, TreeNode right) {
	   this.val = val;
	   this.left = left;
	   this.right = right;
	}
	
}

public class E226_Invert_Binary_Tree {

	public static void main(String[] args) {
		E226_Invert_Binary_Tree solution = new E226_Invert_Binary_Tree();
		TreeNode root = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
		TreeNode rootCopy = deepCopy(root);
		TreeNode invertedRoot = solution.invertTree(rootCopy);
		System.out.println("input: " + serialize(root) + "\noutput: " + serialize(invertedRoot));
	}
	
	/*
    solution:
    1. Base Case: If the node is null, just return null.
	2. Recursive Case: Recursively invert the left and right subtrees.
	3. Swap: Swap the left and right children after the recursion.
    */
	
	/*
     * @param root: a binary tree node
     * @return: its root
     */
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
	
	public static List<Integer> serialize(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    if (root == null) return result;

	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);

	    while (!queue.isEmpty()) {
	        TreeNode node = queue.poll();
	        if (node != null) {
	            result.add(node.val);
	            queue.offer(node.left);
	            queue.offer(node.right);
	        } else {
	            result.add(null); // To match structure if needed
	        }
	    }

	    // Trim trailing nulls
	    int i = result.size() - 1;
	    while (i >= 0 && result.get(i) == null) {
	        result.remove(i--);
	    }

	    return result;
	}
	
	public static TreeNode deepCopy(TreeNode node) {
	    if (node == null) return null;
	    return new TreeNode(node.val, deepCopy(node.left), deepCopy(node.right));
	}

}
