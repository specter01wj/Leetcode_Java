package com.pathSum;
import java.util.*;

/*Given the root of a binary tree and an integer targetSum, 
 return true if the tree has a root-to-leaf path such that adding up 
 all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Example 3:

Input: root = [1,2], targetSum = 0
Output: false*/

public class E112_Path_Sum {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(5);
		input.left = new TreeNode(4);
		input.right = new TreeNode(8);
		input.left.left = new TreeNode(11);
		input.left.right = new TreeNode();
		input.right.left = new TreeNode(13);
		input.right.right = new TreeNode(4);
		input.left.left.left = new TreeNode(7);
		input.left.left.right = new TreeNode(2);
		input.right.left.left = new TreeNode();
		input.right.left.right = new TreeNode();
		input.right.right.left = new TreeNode();
		input.right.right.right = new TreeNode(1);
		Boolean output = hasPathSum(input, 22);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用深度搜索的方法，当搜索到叶子节点时，比较与目标和的值，若相同，
    则结果为真，若搜索完毕没有出现目标和，返回假
    */
	
	/**
     * @param root: the tree
     * @param sum: the sum
     * @return:  if the tree has a root-to-leaf path 
     */
	public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else if (root.val == targetSum && root.left == null && root.right == null) return true;
        else return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
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
