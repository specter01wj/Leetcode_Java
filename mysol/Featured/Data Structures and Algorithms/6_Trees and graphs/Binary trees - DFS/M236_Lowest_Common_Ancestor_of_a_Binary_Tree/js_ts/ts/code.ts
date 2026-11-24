
(document.getElementById("title") as HTMLElement).innerHTML =
    "236. Lowest Common Ancestor of a Binary Tree";

class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(
        val: number = 0,
        left: TreeNode | null = null,
        right: TreeNode | null = null
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function lowestCommonAncestor(
    root: TreeNode | null,
    p: TreeNode | null,
    q: TreeNode | null
): TreeNode | null {
    if (root === null || root === p || root === q) {
        return root;
    }

    let left: TreeNode | null = lowestCommonAncestor(root.left, p, q);
    let right: TreeNode | null = lowestCommonAncestor(root.right, p, q);

    if (left !== null && right !== null) {
        return root;
    }

    return left !== null ? left : right;
}

let output: string = "";

// Example 1
let root1: TreeNode = new TreeNode(3);
root1.left = new TreeNode(5);
root1.right = new TreeNode(1);
root1.left.left = new TreeNode(6);
root1.left.right = new TreeNode(2);
root1.right.left = new TreeNode(0);
root1.right.right = new TreeNode(8);
root1.left.right.left = new TreeNode(7);
root1.left.right.right = new TreeNode(4);

let p1: TreeNode = root1.left;
let q1: TreeNode = root1.right;

output += "<b>Input:</b> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1<br>";
output += "<b>Output:</b> " + lowestCommonAncestor(root1, p1, q1)?.val + "<br><br>";

// Example 2
let root2: TreeNode = root1;
let p2: TreeNode = root2.left!;
let q2: TreeNode = root2.left!.right!.right!;

output += "<b>Input:</b> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4<br>";
output += "<b>Output:</b> " + lowestCommonAncestor(root2, p2, q2)?.val + "<br><br>";

// Example 3
let root3: TreeNode = new TreeNode(1);
root3.left = new TreeNode(2);

let p3: TreeNode = root3;
let q3: TreeNode = root3.left;

output += "<b>Input:</b> root = [1,2], p = 1, q = 2<br>";
output += "<b>Output:</b> " + lowestCommonAncestor(root3, p3, q3)?.val + "<br><br>";

// Example 4
let root4: TreeNode = root1;
let p4: TreeNode = root4.left!.right!.left!;
let q4: TreeNode = root4.left!.right!.right!;

output += "<b>Input:</b> root = [3,5,1,6,2,0,8,null,null,7,4], p = 7, q = 4<br>";
output += "<b>Output:</b> " + lowestCommonAncestor(root4, p4, q4)?.val + "<br><br>";

// Example 5
let root5: TreeNode = root1;
let p5: TreeNode = root5.right!.left!;
let q5: TreeNode = root5.right!.right!;

output += "<b>Input:</b> root = [3,5,1,6,2,0,8,null,null,7,4], p = 0, q = 8<br>";
output += "<b>Output:</b> " + lowestCommonAncestor(root5, p5, q5)?.val + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;
