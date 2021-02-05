package com.binaryTreeLevelOrderTraversalII;
import java.util.*;

/*Given a binary tree, return the bottom-up level order traversal of 
 its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/

public class E107_Binary_Tree_Level_Order_Traversal_II {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(9);
		input.right = new TreeNode(20);
		input.right.left = new TreeNode(15);
		input.right.right = new TreeNode(7);
		List<List<Integer>> output = levelOrderBottom(input);
        System.out.println("input1: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    利用队列层序遍历整棵树，最后翻转一下即可。
    */
	
	/**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        
        Collections.reverse(result);
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
