package com.lowestCommonAncestorofaBinaryTree;
import java.util.*;

/*
Given a binary tree, find the lowest common ancestor (LCA) of 
two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest 
common ancestor is defined between two nodes p and q as the 
lowest node in T that has both p and q as descendants (where 
we allow a node to be a descendant of itself).”
*/

public class M236_Lowest_Common_Ancestor_of_a_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(3);
		input1.left = new TreeNode(5);
		input1.right = new TreeNode(1);
		input1.left.left = new TreeNode(6);
		input1.left.right = new TreeNode(2);
		input1.right.left = new TreeNode(0);
		input1.right.right = new TreeNode(8);
		input1.left.right.left = new TreeNode(7);
		input1.left.right.right = new TreeNode(4);
		
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		TreeNode output = lowestCommonAncestor(input1, p, q);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + treeToArray(output));
	}
	
	/*
    solution:
    DFS
    */
	
	/**
     * @param root: The root of binary tree
     * @param p: a TreeNode
     * @param q: a TreeNode
     * @return: a TreeNode
     */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return null
        if (root == null) {
            return null;
        }
        
        // If one of p or q is found, return that node
        if (root == p || root == q) {
            return root;
        }
        
        // Search for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If p and q found in left and right subtrees of the current node, return current node
        if (left != null && right != null) {
            return root;
        }
        
        // If p and q found in only one subtree, return that subtree
        return left != null ? left : right;
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
   	    TreeNode(int x) { val = x; }
   	}

}
