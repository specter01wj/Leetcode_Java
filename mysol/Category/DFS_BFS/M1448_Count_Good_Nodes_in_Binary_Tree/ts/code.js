function goodNodes(root) {
    function countGoodNodes(node, maxSoFar) {
        if (node === null) {
            return 0;
        }
        var count = 0;
        // Increment count if the current node's value is greater than or equal to the maximum value seen so far
        if (node.val >= maxSoFar) {
            count = 1;
        }
        // Update the maximum value seen so far
        maxSoFar = Math.max(maxSoFar, node.val);
        // Recursively count good nodes in the left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);
        return count;
    }
    return countGoodNodes(root, -Infinity);
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
var input1 = [3, 1, 4, 3, null, 1, 5];
var root1 = arrayToTree(input1);
var output1 = goodNodes(root1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
