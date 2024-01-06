package com.longestZigZagPathinaBinaryTree;
import java.util.*;

/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

 .Choose any node in the binary tree and a direction (right or left).
 .If the current direction is right, move to the right child of 
  the current node; otherwise, move to the left child.
 .Change the direction from right to left or from left to right.
 .Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. 
(A single node has a length of 0).

Return the longest ZigZag path contained in that tree.
*/

public class M1372_Longest_ZigZag_Path_in_a_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.right = new TreeNode(1);
		input1.right.left = new TreeNode(1);
		input1.right.right = new TreeNode(1);
		input1.right.right.left = new TreeNode(1);
		input1.right.right.right = new TreeNode(1);
		input1.right.right.left.right = new TreeNode(1);
		input1.right.right.left.right.right = new TreeNode(1);
		
		int output = longestZigZag(input1);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/**
     * @param root: The root of binary tree
     * @return: an integer
     */
	public static int longestZigZag(TreeNode root) {
        return dfs(root, -1, 0) - 1; // -1 for initial direction, 0 for initial length
    }

    private static int dfs(TreeNode node, int direction, int length) {
        if (node == null) return length;

        // Left direction = 0, Right direction = 1
        int leftLength = (direction == 1) ? dfs(node.left, 0, length + 1) : dfs(node.left, 0, 1);
        int rightLength = (direction == 0) ? dfs(node.right, 1, length + 1) : dfs(node.right, 1, 1);

        return Math.max(length, Math.max(leftLength, rightLength));
    }
    
    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls to clean up the representation
        while (result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
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
