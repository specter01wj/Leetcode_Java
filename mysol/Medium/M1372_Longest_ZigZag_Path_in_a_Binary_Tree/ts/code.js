function longestZigZag(root) {
    return dfs(root, -1, 0) - 1; // -1 for initial direction, 0 for initial length
}
function dfs(node, direction, length) {
    if (node === null)
        return length;
    // Left direction = 0, Right direction = 1
    var leftLength = (direction === 1) ? dfs(node.left, 0, length + 1) : dfs(node.left, 0, 1);
    var rightLength = (direction === 0) ? dfs(node.right, 1, length + 1) : dfs(node.right, 1, 1);
    return Math.max(length, Math.max(leftLength, rightLength));
}
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
var input1 = [1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1];
var root1 = arrayToTree(input1);
var output1 = longestZigZag(root1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
