
(document.getElementById("title") as HTMLElement).innerHTML = "100. Same Tree";

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

function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
    if (p === null && q === null) {
        return true;
    }

    if (p === null || q === null) {
        return false;
    }

    return p.val === q.val
        && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
}

let output: string = "";

// Example 1
let p1: TreeNode = new TreeNode(1,
    new TreeNode(2),
    new TreeNode(3)
);

let q1: TreeNode = new TreeNode(1,
    new TreeNode(2),
    new TreeNode(3)
);

output += "<b>Input:</b> p = [1,2,3], q = [1,2,3]<br>";
output += "<b>Output:</b> " + isSameTree(p1, q1) + "<br><br>";

// Example 2
let p2: TreeNode = new TreeNode(1,
    new TreeNode(2),
    null
);

let q2: TreeNode = new TreeNode(1,
    null,
    new TreeNode(2)
);

output += "<b>Input:</b> p = [1,2], q = [1,null,2]<br>";
output += "<b>Output:</b> " + isSameTree(p2, q2) + "<br><br>";

// Example 3
let p3: TreeNode = new TreeNode(1,
    new TreeNode(2),
    new TreeNode(1)
);

let q3: TreeNode = new TreeNode(1,
    new TreeNode(1),
    new TreeNode(2)
);

output += "<b>Input:</b> p = [1,2,1], q = [1,1,2]<br>";
output += "<b>Output:</b> " + isSameTree(p3, q3) + "<br><br>";

// Example 4
let p4: TreeNode | null = null;
let q4: TreeNode | null = null;

output += "<b>Input:</b> p = [], q = []<br>";
output += "<b>Output:</b> " + isSameTree(p4, q4) + "<br><br>";

// Example 5
let p5: TreeNode = new TreeNode(1);
let q5: TreeNode | null = null;

output += "<b>Input:</b> p = [1], q = []<br>";
output += "<b>Output:</b> " + isSameTree(p5, q5) + "<br>";

(document.getElementById("output") as HTMLElement).innerHTML = output;
