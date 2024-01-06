function lowestCommonAncestor(root, p, q) {
    if (root === null || root === p || root === q) {
        return root;
    }
    var left = lowestCommonAncestor(root.left, p, q);
    var right = lowestCommonAncestor(root.right, p, q);
    if (left !== null && right !== null) {
        return root;
    }
    return left !== null ? left : right;
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
var input1 = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4];
var p = [5], q = [1];
var p1 = arrayToTree(p);
var q1 = arrayToTree(q);
var root1 = arrayToTree(input1);
var output1 = lowestCommonAncestor(root1, p1, q1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
