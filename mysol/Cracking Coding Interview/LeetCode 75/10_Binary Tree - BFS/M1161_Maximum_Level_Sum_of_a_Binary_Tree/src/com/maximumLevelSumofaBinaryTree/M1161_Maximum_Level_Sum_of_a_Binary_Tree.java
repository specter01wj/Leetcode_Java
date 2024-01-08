package com.maximumLevelSumofaBinaryTree;
import java.util.*;

/*
Given the root of a binary tree, the level of its root is 1, 
the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values 
of nodes at level x is maximal.
*/

public class M1161_Maximum_Level_Sum_of_a_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.left = new TreeNode(7);
		input1.right = new TreeNode(0);
		input1.left.left = new TreeNode(7);
		input1.left.right = new TreeNode(-8);
		
		int output = maxLevelSum(input1);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    BFS
    */
	
	/**
     * @param root: The root of binary tree
     * @return: the smallest level x
     */
	public static int maxLevelSum(TreeNode root) {
		if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1, currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
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
