package com.searchinaBinarySearchTree;
import java.util.*;

/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return 
the subtree rooted with that node. If such a node does not exist, return null.
*/

public class E700_Search_in_a_Binary_Search_Tree {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(4);
		input1.left = new TreeNode(2);
		input1.right = new TreeNode(7);
		input1.left.left = new TreeNode(1);
		input1.left.right = new TreeNode(3);
		
		int val = 2;
		
		TreeNode output = searchBST(input1, val);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + treeToArray(output));
	}
	
	/*
    solution:
    BST
    */
	
	/**
     * @param root: The root of binary tree
     * @param val: an integer
     * @return: the subtree rooted with that node
     */
	public static TreeNode searchBST(TreeNode root, int val) {
	       // Base case: if the root is null or the root's value is the target value
	        if (root == null || root.val == val) {
	            return root;
	        }

	        // Since it's a BST, if the target value is less than the root's value,
	        // search in the left subtree. Otherwise, search in the right subtree.
	        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val); 
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
