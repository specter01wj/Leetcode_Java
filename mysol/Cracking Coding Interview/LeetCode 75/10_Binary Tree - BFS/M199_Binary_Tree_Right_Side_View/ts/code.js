function rightSideView(root) {
    if (!root)
        return [];
    var queue = [root];
    var visibleValues = [];
    while (queue.length > 0) {
        var levelSize = queue.length;
        for (var i = 0; i < levelSize; i++) {
            var currentNode = queue.shift();
            if (currentNode) {
                // If it's the last node in the current level, add it to the result array.
                if (i === levelSize - 1) {
                    visibleValues.push(currentNode.val);
                }
                // Add child nodes to the queue for the next level.
                if (currentNode.left) {
                    queue.push(currentNode.left);
                }
                if (currentNode.right) {
                    queue.push(currentNode.right);
                }
            }
        }
    }
    return visibleValues;
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
var input1 = [1, 2, 3, null, 5, null, 4];
var root1 = arrayToTree(input1);
var output1 = rightSideView(root1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
