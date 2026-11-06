package com.jinwang;

public class E104_Maximum_Depth_of_Binary_Tree {
	
	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

	public static void main(String[] args) {
		E104_Maximum_Depth_of_Binary_Tree solution =
                new E104_Maximum_Depth_of_Binary_Tree();

        // Example 1: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        System.out.println("Input: [3,9,20,null,null,15,7]");
        System.out.println("Output: " + solution.maxDepth(root1));

        // Example 2: [1,null,2]
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2));

        System.out.println("Input: [1,null,2]");
        System.out.println("Output: " + solution.maxDepth(root2));

        // Example 3: Empty tree
        TreeNode root3 = null;

        System.out.println("Input: []");
        System.out.println("Output: " + solution.maxDepth(root3));

        // Example 4: Single node
        TreeNode root4 = new TreeNode(1);

        System.out.println("Input: [1]");
        System.out.println("Output: " + solution.maxDepth(root4));
	}

}
