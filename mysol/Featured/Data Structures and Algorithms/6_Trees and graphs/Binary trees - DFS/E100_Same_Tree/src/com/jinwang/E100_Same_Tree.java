package com.jinwang;

public class E100_Same_Tree {
	
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

	public static void main(String[] args) {
		E100_Same_Tree solution = new E100_Same_Tree();

        // Example 1
        TreeNode p1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        TreeNode q1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        System.out.println("Input: p = [1,2,3], q = [1,2,3]");
        System.out.println("Output: " + solution.isSameTree(p1, q1));

        // Example 2
        TreeNode p2 = new TreeNode(1,
                new TreeNode(2),
                null);

        TreeNode q2 = new TreeNode(1,
                null,
                new TreeNode(2));

        System.out.println("Input: p = [1,2], q = [1,null,2]");
        System.out.println("Output: " + solution.isSameTree(p2, q2));

        // Example 3
        TreeNode p3 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(1));

        TreeNode q3 = new TreeNode(1,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println("Input: p = [1,2,1], q = [1,1,2]");
        System.out.println("Output: " + solution.isSameTree(p3, q3));

        // Example 4: Both empty trees
        TreeNode p4 = null;
        TreeNode q4 = null;

        System.out.println("Input: p = [], q = []");
        System.out.println("Output: " + solution.isSameTree(p4, q4));

        // Example 5: One empty tree
        TreeNode p5 = new TreeNode(1);
        TreeNode q5 = null;

        System.out.println("Input: p = [1], q = []");
        System.out.println("Output: " + solution.isSameTree(p5, q5));
	}

}
