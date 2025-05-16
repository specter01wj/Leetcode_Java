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
	
	@Override
	public String toString() {
	   return "[" + val + ", " + left.val + ", " + right.val + "]";
	}
}

public class E226_Invert_Binary_Tree {

	public static void main(String[] args) {
		E226_Invert_Binary_Tree solution = new E226_Invert_Binary_Tree();
		TreeNode root = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
		TreeNode invertedRoot = solution.invertTree(root);
		System.out.println("input: " + (root) + "\noutput: " + (invertedRoot));
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

}
