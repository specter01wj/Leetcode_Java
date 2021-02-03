package com.sameTree;
import java.util.*;

/*Given the roots of two binary trees p and q, write a function 
 to check if they are the same or not.

Two binary trees are considered the same if they are structurally 
identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false*/

public class E100_Same_Tree {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.left = new TreeNode(2);
		input1.right = new TreeNode(3);
		TreeNode input2 = new TreeNode(1);
		input2.left = new TreeNode(2);
		input2.right = new TreeNode(3);
		Boolean output = isSameTree(input1, input2);
        System.out.println("input1: " + (input1) + "input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    每次选择一个区间的中点作为当前区间的根，然后对左右子树依次构造。
    */
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
        return false;
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
