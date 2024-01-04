package com.countGoodNodesinBinaryTree;
import java.util.*;

/*
Given a binary tree root, a node X in the tree is named good if in 
the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
*/

public class M1448_Count_Good_Nodes_in_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(1);
		input.right = new TreeNode(4);
		input.left.left = new TreeNode(3);
		input.right.left = new TreeNode(1);
		input.right.right = new TreeNode(5);
		
		int output = goodNodes(input);
        System.out.println("input1: " + treeToArray(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/**
     * @param root: The root of binary tree.
     * @return: the number of good nodes in the binary tree
     */
	public static int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private static int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        // Increment count if the current node's value is greater than or equal to the maximum value seen so far
        int count = node.val >= maxSoFar ? 1 : 0;

        // Update the maximum value seen so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // Recursively count good nodes in the left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
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
