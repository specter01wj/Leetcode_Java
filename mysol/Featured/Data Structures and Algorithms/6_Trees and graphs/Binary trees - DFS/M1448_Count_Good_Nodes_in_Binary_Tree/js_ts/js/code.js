
document.getElementById("title").innerHTML =
    "1448. Count Good Nodes in Binary Tree";

function TreeNode(val = 0, left = null, right = null) {
    this.val = val;
    this.left = left;
    this.right = right;
}

var goodNodes = function(root) {
    function countGoodNodes(node, maxSoFar) {
        if (node === null) {
            return 0;
        }

        let count = node.val >= maxSoFar ? 1 : 0;
        let newMax = Math.max(maxSoFar, node.val);

        count += countGoodNodes(node.left, newMax);
        count += countGoodNodes(node.right, newMax);

        return count;
    }

    return countGoodNodes(root, -Infinity);
};

let output = "";

// Example 1
let root1 = new TreeNode(3,
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
let root2 = new TreeNode(3,
    new TreeNode(3,
        new TreeNode(4),
        new TreeNode(2)
    ),
    null
);

output += "<b>Input:</b> root = [3,3,null,4,2]<br>";
output += "<b>Output:</b> " + goodNodes(root2) + "<br><br>";

// Example 3
let root3 = new TreeNode(1);

output += "<b>Input:</b> root = [1]<br>";
output += "<b>Output:</b> " + goodNodes(root3) + "<br><br>";

// Example 4
let root4 = new TreeNode(-1,
    new TreeNode(-2),
    new TreeNode(0)
);

output += "<b>Input:</b> root = [-1,-2,0]<br>";
output += "<b>Output:</b> " + goodNodes(root4) + "<br>";

document.getElementById("output").innerHTML = output;
