
(document.getElementById("title") as HTMLElement).innerHTML =
    "104. Maximum Depth of Binary Tree";

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

function maxDepth(root: TreeNode | null): number {
    if (root === null) {
        return 0;
    }

    let left: number = maxDepth(root.left);
    let right: number = maxDepth(root.right);

    return Math.max(left, right) + 1;
}

let output: string = "";

// Example 1
let root1: TreeNode = new TreeNode(3,
    new TreeNode(9),
    new TreeNode(20,
        new TreeNode(15),
        new TreeNode(7)
    )
);

output += "<b>Input:</b> root = [3,9,20,null,null,15,7]<br>";
output += "<b>Output:</b> " + maxDepth(root1) + "<br><br>";

// Example 2
let root2: TreeNode = new TreeNode(1, null, new TreeNode(2));

output += "<b>Input:</b> root = [1,null,2]<br>";
output += "<b>Output:</b> " + maxDepth(root2) + "<br><br>";

// Example 3
let root3: TreeNode | null = null;

output += "<b>Input:</b> root = []<br>";
output += "<b>Output:</b> " + maxDepth(root3) + "<br><br>";

// Example 4
let root4: TreeNode = new TreeNode(1);

output += "<b>Input:</b> root = [1]<br>";
output += "<b>Output:</b> " + maxDepth(root4) + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;
