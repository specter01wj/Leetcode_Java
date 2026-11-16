package com.jinwang;

public class Ch6_Binary_Tree_DFS_Traversal {

	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Preorder: Root -> Left -> Right
    public void preorderDfs(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorderDfs(node.left);
        preorderDfs(node.right);
    }

    // Inorder: Left -> Root -> Right
    public void inorderDfs(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderDfs(node.left);
        System.out.print(node.val + " ");
        inorderDfs(node.right);
    }

    // Postorder: Left -> Right -> Root
    public void postorderDfs(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderDfs(node.left);
        postorderDfs(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
    	Ch6_Binary_Tree_DFS_Traversal solution =
                new Ch6_Binary_Tree_DFS_Traversal();

        /*
                  0
                 / \
                1   2
               / \   \
              3   4   5
                   \
                    6
        */

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.left.right.right = new TreeNode(6);
        root1.right.right = new TreeNode(5);

        System.out.println("Example 1: [0,1,2,3,4,null,5,null,null,null,6]");
        System.out.print("Preorder: ");
        solution.preorderDfs(root1);
        System.out.println();

        System.out.print("Inorder: ");
        solution.inorderDfs(root1);
        System.out.println();

        System.out.print("Postorder: ");
        solution.postorderDfs(root1);
        System.out.println("\n");

        /*
                  0
                 / \
                1   2
        */

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println("Example 2: [0,1,2]");
        System.out.print("Preorder: ");
        solution.preorderDfs(root2);
        System.out.println();

        System.out.print("Inorder: ");
        solution.inorderDfs(root2);
        System.out.println();

        System.out.print("Postorder: ");
        solution.postorderDfs(root2);
        System.out.println("\n");

        // Example 3: Single node
        TreeNode root3 = new TreeNode(1);

        System.out.println("Example 3: [1]");
        System.out.print("Preorder: ");
        solution.preorderDfs(root3);
        System.out.println();

        System.out.print("Inorder: ");
        solution.inorderDfs(root3);
        System.out.println();

        System.out.print("Postorder: ");
        solution.postorderDfs(root3);
        System.out.println("\n");

        // Example 4: Empty tree
        TreeNode root4 = null;

        System.out.println("Example 4: []");
        System.out.print("Preorder: ");
        solution.preorderDfs(root4);
        System.out.println();

        System.out.print("Inorder: ");
        solution.inorderDfs(root4);
        System.out.println();

        System.out.print("Postorder: ");
        solution.postorderDfs(root4);
        System.out.println();
    }

}
