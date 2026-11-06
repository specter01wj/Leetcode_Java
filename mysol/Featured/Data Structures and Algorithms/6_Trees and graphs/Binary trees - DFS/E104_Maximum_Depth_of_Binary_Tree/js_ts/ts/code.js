"use strict";
document.getElementById("title").innerHTML =
    "104. Maximum Depth of Binary Tree";
class TreeNode {
    val;
    left;
    right;
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
function maxDepth(root) {
    if (root === null) {
        return 0;
    }
    let left = maxDepth(root.left);
    let right = maxDepth(root.right);
    return Math.max(left, right) + 1;
}
let output = "";
// Example 1
let root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
output += "<b>Input:</b> root = [3,9,20,null,null,15,7]<br>";
output += "<b>Output:</b> " + maxDepth(root1) + "<br><br>";
// Example 2
let root2 = new TreeNode(1, null, new TreeNode(2));
output += "<b>Input:</b> root = [1,null,2]<br>";
output += "<b>Output:</b> " + maxDepth(root2) + "<br><br>";
// Example 3
let root3 = null;
output += "<b>Input:</b> root = []<br>";
output += "<b>Output:</b> " + maxDepth(root3) + "<br><br>";
// Example 4
let root4 = new TreeNode(1);
output += "<b>Input:</b> root = [1]<br>";
output += "<b>Output:</b> " + maxDepth(root4) + "<br>";
document.getElementById("output").innerHTML = output;
