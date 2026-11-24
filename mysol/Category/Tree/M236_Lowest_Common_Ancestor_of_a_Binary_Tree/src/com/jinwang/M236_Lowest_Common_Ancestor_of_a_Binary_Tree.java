package com.jinwang;

public class M236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

	public static void main(String[] args) {
		M236_Lowest_Common_Ancestor_of_a_Binary_Tree solution =
                new M236_Lowest_Common_Ancestor_of_a_Binary_Tree();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode p1 = root1.left;
        TreeNode q1 = root1.right;

        System.out.println("Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1");
        System.out.println("Output: " + solution.lowestCommonAncestor(root1, p1, q1).val);

        // Example 2
        TreeNode root2 = root1;
        TreeNode p2 = root2.left;
        TreeNode q2 = root2.left.right.right;

        System.out.println("Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4");
        System.out.println("Output: " + solution.lowestCommonAncestor(root2, p2, q2).val);

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);

        TreeNode p3 = root3;
        TreeNode q3 = root3.left;

        System.out.println("Input: root = [1,2], p = 1, q = 2");
        System.out.println("Output: " + solution.lowestCommonAncestor(root3, p3, q3).val);

        // Example 4
        TreeNode root4 = root1;
        TreeNode p4 = root4.left.right.left;
        TreeNode q4 = root4.left.right.right;

        System.out.println("Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 7, q = 4");
        System.out.println("Output: " + solution.lowestCommonAncestor(root4, p4, q4).val);

        // Example 5
        TreeNode root5 = root1;
        TreeNode p5 = root5.right.left;
        TreeNode q5 = root5.right.right;

        System.out.println("Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 0, q = 8");
        System.out.println("Output: " + solution.lowestCommonAncestor(root5, p5, q5).val);
	}

}
