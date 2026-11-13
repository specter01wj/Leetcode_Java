
(document.getElementById("title") as HTMLElement).innerHTML =
    "1448. Count Good Nodes in Binary Tree";

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

function goodNodes(root: TreeNode | null): number {
    function countGoodNodes(node: TreeNode | null, maxSoFar: number): number {
        if (node === null) {
            return 0;
        }

        let count: number = node.val >= maxSoFar ? 1 : 0;
        let newMax: number = Math.max(maxSoFar, node.val);

        count += countGoodNodes(node.left, newMax);
        count += countGoodNodes(node.right, newMax);

        return count;
    }

    return countGoodNodes(root, -Infinity);
}

let output: string = "";

// Example 1
let root1: TreeNode = new TreeNode(3,
    new TreeNode(1,
        new TreeNode(3),
        null
    ),
    new TreeNode(4,
        new TreeNode(1),
        new TreeNode(5)
    )
);

output += "<b>Input:</b> root = [3,1,4,3,null,1,5]<br>";
output += "<b>Output:</b> " + goodNodes(root1) + "<br><br>";

// Example 2
let root2: TreeNode = new TreeNode(3,
    new TreeNode(3,
        new TreeNode(4),
        new TreeNode(2)
    ),
    null
);

output += "<b>Input:</b> root = [3,3,null,4,2]<br>";
output += "<b>Output:</b> " + goodNodes(root2) + "<br><br>";

// Example 3
let root3: TreeNode = new TreeNode(1);

output += "<b>Input:</b> root = [1]<br>";
output += "<b>Output:</b> " + goodNodes(root3) + "<br><br>";

// Example 4
let root4: TreeNode = new TreeNode(-1,
    new TreeNode(-2),
    new TreeNode(0)
);

output += "<b>Input:</b> root = [-1,-2,0]<br>";
output += "<b>Output:</b> " + goodNodes(root4) + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;
