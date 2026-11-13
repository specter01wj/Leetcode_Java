package com.jinwang;

public class E112_Path_Sum {
	
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

	public static void main(String[] args) {
		E112_Path_Sum solution = new E112_Path_Sum();

        // Example 1
        // root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));

        System.out.println("Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22");
        System.out.println("Output: " + solution.hasPathSum(root1, 22));

        // Example 2
        // root = [1,2,3], targetSum = 5
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        System.out.println("Input: root = [1,2,3], targetSum = 5");
        System.out.println("Output: " + solution.hasPathSum(root2, 5));

        // Example 3
        // root = [], targetSum = 0
        TreeNode root3 = null;

        System.out.println("Input: root = [], targetSum = 0");
        System.out.println("Output: " + solution.hasPathSum(root3, 0));

        // Example 4
        // Single node
        TreeNode root4 = new TreeNode(1);

        System.out.println("Input: root = [1], targetSum = 1");
        System.out.println("Output: " + solution.hasPathSum(root4, 1));

        // Example 5
        // Negative values
        TreeNode root5 = new TreeNode(-2,
                null,
                new TreeNode(-3));

        System.out.println("Input: root = [-2,null,-3], targetSum = -5");
        System.out.println("Output: " + solution.hasPathSum(root5, -5));
	}

}
