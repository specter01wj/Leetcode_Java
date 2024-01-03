package com.leafSimilarTrees;
import java.util.*;

/*
Consider all the leaves of a binary tree, from left to right order, 
the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence 
is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value 
sequence is the same.

Return true if and only if the two given trees with head nodes 
root1 and root2 are leaf-similar.
*/

public class E872_LeafSimilar_Trees {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(3);
		input1.left = new TreeNode(5);
		input1.right = new TreeNode(1);
		input1.left.left = new TreeNode(6);
		input1.left.right = new TreeNode(2);
		input1.left.right.left = new TreeNode(7);
		input1.left.right.right = new TreeNode(4);
		input1.right.left = new TreeNode(9);
		input1.right.right = new TreeNode(8);
		
		TreeNode input2 = new TreeNode(3);
		input2.left = new TreeNode(5);
		input2.right = new TreeNode(1);
		input2.left.left = new TreeNode(6);
		input2.left.right = new TreeNode(7);
		input2.right.left = new TreeNode(4);
		input2.right.right = new TreeNode(2);
		input2.right.right.left = new TreeNode(9);
		input2.right.right.right = new TreeNode(8);
		
		boolean output = leafSimilar(input1, input2);
        System.out.println("input1: " + treeToArray(input1) + "; input2: " + treeToArray(input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/**
     * @param root1: The root of binary tree 1.
     * @param root2: The root of binary tree 2.
     * @return: a boolean
     */
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Fill the lists with the leaf values of each tree
        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }
	
	private static void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        dfs(node.left, leaves);
        dfs(node.right, leaves);
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
