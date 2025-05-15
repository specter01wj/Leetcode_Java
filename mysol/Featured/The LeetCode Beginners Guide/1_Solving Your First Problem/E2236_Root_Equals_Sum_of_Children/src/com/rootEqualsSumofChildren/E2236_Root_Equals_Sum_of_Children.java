package com.rootEqualsSumofChildren;
import java.util.*;

/*
You are given the root of a binary tree that consists of exactly 
3 nodes: the root, its left child, and its right child.

Return true if the value of the root is equal to the sum of the 
values of its two children, or false otherwise.
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

public class E2236_Root_Equals_Sum_of_Children {

	public static void main(String[] args) {
		E2236_Root_Equals_Sum_of_Children solution = new E2236_Root_Equals_Sum_of_Children();
		TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(10, left, right);
        boolean output = solution.checkTree(root);
        System.out.println("input: " + (root) + "\noutput: " + (output));
	}
	
	/*
    solution:
    binary tree
    */
	
	/*
     * @param root: a binary tree node
     * @return: true if the value of the root is equal to the sum of the values of its two children
     */
	public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
