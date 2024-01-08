package com.binaryTreeRightSideView;
import java.util.*;

/*
Given the root of a binary tree, imagine yourself standing 
on the right side of it, return the values of the nodes you 
can see ordered from top to bottom.
*/

public class M199_Binary_Tree_Right_Side_View {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.left = new TreeNode(2);
		input1.right = new TreeNode(3);
		input1.left.right = new TreeNode(5);
		input1.right.right = new TreeNode(4);
		
		List<Integer> output = rightSideView(input1);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    BFS
    */
	
	/**
     * @param root: The root of binary tree
     * @return: the values of the nodes you can see ordered from top to bottom
     */
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if (root == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // If it's the last node in the current level, add it to the result list.
                if (i == levelSize - 1) {
                    visibleValues.add(currentNode.val);
                }
                // Add child nodes in the queue for the next level.
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return visibleValues;
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
