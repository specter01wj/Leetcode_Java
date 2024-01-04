function pathSum(root, targetSum) {
    var prefixSumCount = new Map();
    prefixSumCount.set(0, 1); // Initialize with 0 sum having one count
    function findPathSum(node, currentSum) {
        if (node === null) {
            return 0;
        }
        currentSum += node.val;
        var numPathsToCurr = prefixSumCount.get(currentSum - targetSum) || 0;
        // Update the prefixSumCount
        prefixSumCount.set(currentSum, (prefixSumCount.get(currentSum) || 0) + 1);
        // Count paths with sum = target in the left and right subtrees
        var result = numPathsToCurr + findPathSum(node.left, currentSum) + findPathSum(node.right, currentSum);
        // Restore the prefixSumCount (Backtrack)
        prefixSumCount.set(currentSum, prefixSumCount.get(currentSum) - 1);
        return result;
    }
    return findPathSum(root, 0);
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
var input1 = [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1];
var targetSum = 8;
var root1 = arrayToTree(input1);
var output1 = pathSum(root1, targetSum);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
