package com.deleteNodeinaBST;
import java.util.*;

/*
Given a root node reference of a BST and a key, delete the node 
with the given key in the BST. Return the root node reference 
(possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1.Search for a node to remove.
2.If the node is found, delete the node.
*/

public class M450_Delete_Node_in_a_BST {

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
		
		int key = 3;
		
		TreeNode output = deleteNode(input1, key);
        System.out.println("input1: " + treeToArray(input1) + "\noutput: " + treeToArray(output));
	}
	
	/*
    solution:
    BST
    */
	
	/**
     * @param root1: The root of binary tree 1.
     * @param root2: The root of binary tree 2.
     * @return: a boolean
     */
	public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Search for the node.
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found. Now let's delete it.

            // Case 1: Node with only one child or no child.
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children.
            // Get the inorder successor (smallest in the right subtree).
            root.val = minValue(root.right);

            // Delete the inorder successor.
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private static int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
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
