package com.symmetricTree;
import java.util.*;

/*Given a binary tree, check whether it is a mirror of itself 
 (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3*/

public class E101_Symmetric_Tree {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(1);
		input.left = new TreeNode(2);
		input.right = new TreeNode(2);
		input.left.left = new TreeNode(3);
		input.left.right = new TreeNode(4);
		input.right.left = new TreeNode(4);
		input.right.right = new TreeNode(3);
		Boolean output = isSymmetric(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用BFS对整个二叉树进行层级遍历。在每层中使用Stack判断是否对称。
    */
	
	/**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself 
     */
	public static boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }
    
    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left==null || right==null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
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
