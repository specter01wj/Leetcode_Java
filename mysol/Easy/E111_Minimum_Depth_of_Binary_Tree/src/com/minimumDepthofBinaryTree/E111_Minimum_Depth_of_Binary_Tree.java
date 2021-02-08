package com.minimumDepthofBinaryTree;
import java.util.*;

/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from 
the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5*/

public class E111_Minimum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(9);
		input.right = new TreeNode(20);
		input.left.left = new TreeNode(null);
		input.left.right = new TreeNode(null);
		input.right.left = new TreeNode(15);
		input.right.right = new TreeNode(7);
		int output = minDepth(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    直接搜索给出的二叉树即可。
    */
	
	/**
     * @param root: The root of binary tree
     * @return: An integer
     */
	public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }
    
    public static int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
	
	public static class TreeNode {
    	int val;
   	    TreeNode left;
   	    TreeNode right;
   	    TreeNode(Object object) {}
   	    TreeNode(int val) { this.val = val; }
   	    TreeNode(int val, TreeNode left, TreeNode right) {
   	        this.val = val;
   	        this.left = left;
   	        this.right = right;
        }
   	}

}
