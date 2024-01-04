package com.pathSumIII;
import java.util.*;

/*
Given the root of a binary tree and an integer targetSum, 
return the number of paths where the sum of the values along 
the path equals targetSum.

The path does not need to start or end at the root or a leaf, 
but it must go downwards (i.e., traveling only from parent 
nodes to child nodes).
*/

public class M437_Path_Sum_III {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(10);
		input1.left = new TreeNode(5);
		input1.right = new TreeNode(-3);
		input1.left.left = new TreeNode(3);
		input1.left.right = new TreeNode(2);
		input1.left.left.left = new TreeNode(3);
		input1.left.left.right = new TreeNode(-2);
		input1.left.right.right = new TreeNode(1);
		input1.right.right = new TreeNode(11);
		
		int targetSum = 8;
		
		int output = pathSum(input1, targetSum);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/**
     * @param root: The root of binary tree
     * @param targetSum: an integer
     * @return: the number of paths where the sum of the values along the path equals targetSum
     */
	public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); 
        return findPathSum(root, 0, targetSum, prefixSumCount);
    }

    private static int findPathSum(TreeNode node, long currentSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - target, 0);

        // Update the prefixSumCount
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Count paths with sum = target in the left and right subtrees
        int result = numPathsToCurr + findPathSum(node.left, currentSum, target, prefixSumCount)
                     + findPathSum(node.right, currentSum, target, prefixSumCount);

        // Restore the prefixSumCount (Backtrack)
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
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
