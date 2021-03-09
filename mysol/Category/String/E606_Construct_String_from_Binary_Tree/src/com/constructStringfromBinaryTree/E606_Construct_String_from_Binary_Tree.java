package com.constructStringfromBinaryTree;
import java.util.*;

/*You need to construct a string consists of parenthesis and 
integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis 
pair "()". And you need to omit all the empty parenthesis 
pairs that don't affect the one-to-one mapping relationship 
between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break 
the one-to-one mapping relationship between the input and the output.*/

public class E606_Construct_String_from_Binary_Tree {

	public static void main(String[] args) {
		TreeNode input = {1,2,3,4};
        String output = tree2str(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	public static String tree2str(TreeNode t) {
		if (t == null) return "";
        String s = String.valueOf(t.val);
        boolean haveLeft = false;
        if(t.left != null) {
            haveLeft = true;
            s += '(' + tree2str(t.left) + ')';
        }
        if(t.right != null) {
            if(!haveLeft) s+="()";
            s += '(' + tree2str(t.right) + ')';
        }
        return s;
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
