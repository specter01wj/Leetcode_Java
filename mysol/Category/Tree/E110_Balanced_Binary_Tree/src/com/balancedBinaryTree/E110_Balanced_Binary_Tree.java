package com.balancedBinaryTree;
import java.util.*;

/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ 
in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true*/

public class E110_Balanced_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(9);
		input.right = new TreeNode(20);
		input.right.left = new TreeNode(15);
		input.right.right = new TreeNode(7);
		Boolean output = isBalanced(input);
        System.out.println("input1: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    在树上做一次DFS，记录以每个点为根的子树高度。
	解法2中提供了更简洁的方法，将子树高度作为返回值返回。
    */
	
	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
	public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
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
