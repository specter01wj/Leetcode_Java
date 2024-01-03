function maxDepth(root) {
    if (root === null) {
        return 0;
    }
    var leftDepth = maxDepth(root.left);
    var rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
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
var input1 = [3, 9, 20, null, null, 15, 7];
var linkedListInput = arrayToTree(input1);
var output1 = maxDepth(linkedListInput);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
