
(document.getElementById("title") as HTMLElement).innerHTML = "112. Path Sum";

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

function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
    if (root === null) {
        return false;
    }

    if (root.left === null && root.right === null) {
        return root.val === targetSum;
    }

    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
}

let output: string = "";

// Example 1
let root1: TreeNode = new TreeNode(5,
    new TreeNode(4,
        new TreeNode(11,
            new TreeNode(7),
            new TreeNode(2)
        ),
        null
    ),
    new TreeNode(8,
        new TreeNode(13),
        new TreeNode(4,
            null,
            new TreeNode(1)
        )
    )
);

output += "<b>Input:</b> root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22<br>";
output += "<b>Output:</b> " + hasPathSum(root1, 22) + "<br><br>";

// Example 2
let root2: TreeNode = new TreeNode(1,
    new TreeNode(2),
    new TreeNode(3)
);

output += "<b>Input:</b> root = [1,2,3], targetSum = 5<br>";
output += "<b>Output:</b> " + hasPathSum(root2, 5) + "<br><br>";

// Example 3
let root3: TreeNode | null = null;

output += "<b>Input:</b> root = [], targetSum = 0<br>";
output += "<b>Output:</b> " + hasPathSum(root3, 0) + "<br><br>";

// Example 4
let root4: TreeNode = new TreeNode(1);

output += "<b>Input:</b> root = [1], targetSum = 1<br>";
output += "<b>Output:</b> " + hasPathSum(root4, 1) + "<br><br>";

// Example 5
let root5: TreeNode = new TreeNode(-2,
    null,
    new TreeNode(-3)
);

output += "<b>Input:</b> root = [-2,null,-3], targetSum = -5<br>";
output += "<b>Output:</b> " + hasPathSum(root5, -5) + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;
