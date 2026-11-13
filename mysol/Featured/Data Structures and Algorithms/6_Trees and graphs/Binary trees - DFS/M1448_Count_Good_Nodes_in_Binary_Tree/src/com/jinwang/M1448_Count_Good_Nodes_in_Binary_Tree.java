package com.jinwang;

public class M1448_Count_Good_Nodes_in_Binary_Tree {
	
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

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = node.val >= maxSoFar ? 1 : 0;
        int newMax = Math.max(maxSoFar, node.val);

        count += countGoodNodes(node.left, newMax);
        count += countGoodNodes(node.right, newMax);

        return count;
    }

	public static void main(String[] args) {
		M1448_Count_Good_Nodes_in_Binary_Tree solution =
                new M1448_Count_Good_Nodes_in_Binary_Tree();

        // Example 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3),
                        null),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(5)));

        System.out.println("Input: root = [3,1,4,3,null,1,5]");
        System.out.println("Output: " + solution.goodNodes(root1));

        // Example 2
        TreeNode root2 = new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(2)),
                null);

        System.out.println("Input: root = [3,3,null,4,2]");
        System.out.println("Output: " + solution.goodNodes(root2));

        // Example 3
        TreeNode root3 = new TreeNode(1);

        System.out.println("Input: root = [1]");
        System.out.println("Output: " + solution.goodNodes(root3));

        // Example 4: Negative values
        TreeNode root4 = new TreeNode(-1,
                new TreeNode(-2),
                new TreeNode(0));

        System.out.println("Input: root = [-1,-2,0]");
        System.out.println("Output: " + solution.goodNodes(root4));
	}

}
