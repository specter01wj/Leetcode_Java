function maxLevelSum(root) {
    if (!root)
        return 0;
    var queue = [root];
    var maxSum = -Infinity;
    var maxLevel = 1;
    var currentLevel = 1;
    while (queue.length > 0) {
        var levelSize = queue.length;
        var levelSum = 0;
        for (var i = 0; i < levelSize; i++) {
            var currentNode = queue.shift();
            levelSum += currentNode.val;
            if (currentNode.left)
                queue.push(currentNode.left);
            if (currentNode.right)
                queue.push(currentNode.right);
        }
        if (levelSum > maxSum) {
            maxSum = levelSum;
            maxLevel = currentLevel;
        }
        currentLevel++;
    }
    return maxLevel;
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
var input1 = [1, 7, 0, 7, -8, null, null];
var root1 = arrayToTree(input1);
var output1 = maxLevelSum(root1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
