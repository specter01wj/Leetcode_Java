function leafSimilar(root1, root2) {
    var leaves1 = [];
    var leaves2 = [];
    // Helper function to perform DFS and collect leaf values
    function dfs(node, leaves) {
        if (node === null) {
            return;
        }
        if (node.left === null && node.right === null) {
            leaves.push(node.val);
        }
        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }
    // Collect leaf values for both trees
    dfs(root1, leaves1);
    dfs(root2, leaves2);
    // Compare the leaf value sequences
    if (leaves1.length !== leaves2.length) {
        return false;
    }
    for (var i = 0; i < leaves1.length; i++) {
        if (leaves1[i] !== leaves2[i]) {
            return false;
        }
    }
    return true;
}
;
var TreeNode = /** @class */ (function () {
    function TreeNode(val, left, right) {
        this.val = (val === undefined ? 0 : val);
        this.left = (left === undefined ? null : left);
        this.right = (right === undefined ? null : right);
    }
    return TreeNode;
}());
function arrayToTree(arr) {
    if (arr.length === 0)
        return null;
    var root = new TreeNode(arr[0]);
    var queue = [root];
    for (var i = 1; i < arr.length; i++) {
        var parent_1 = queue[0];
        if (i % 2 === 1) {
            if (arr[i] != null) {
                parent_1.left = new TreeNode(arr[i]);
                queue.push(parent_1.left);
            }
        }
        else {
            if (arr[i] != null) {
                parent_1.right = new TreeNode(arr[i]);
                queue.push(parent_1.right);
            }
            queue.shift(); // Remove the processed node
        }
    }
    return root;
}
var input1 = [3, 5, 1, 6, 2, 9, 8, null, null, 7, 4];
var input2 = [3, 5, 1, 6, 2, 9, 8, null, null, 7, 4];
var root1 = arrayToTree(input1);
var root2 = arrayToTree(input2);
var output1 = leafSimilar(root1, root2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
