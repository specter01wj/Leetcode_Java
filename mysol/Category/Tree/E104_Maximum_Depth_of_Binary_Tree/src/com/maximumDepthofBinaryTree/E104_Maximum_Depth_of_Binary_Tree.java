package com.maximumDepthofBinaryTree;
import java.util.*;

/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest 
path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1*/

public class E104_Maximum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(9);
		input.right = new TreeNode(20);
		input.left.left = new TreeNode(0);
		input.left.right = new TreeNode(0);
		input.right.left = new TreeNode(15);
		input.right.right = new TreeNode(7);
		int output = maxDepth(input);
        System.out.println("input1: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    简单的树的遍历，点i为根的树高度，等于高度最大的子树的高度+1。
    */
	
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
	
	public static class TreeNode {
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

}
