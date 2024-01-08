function searchBST(root, val) {
    // Base case: if the root is null or the root's value is the target value
    if (root === null || root.val === val) {
        return root;
    }
    // If the target value is less than the root's value,
    // search in the left subtree. Otherwise, search in the right subtree.
    return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
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
function treeToArray(root) {
    if (!root)
        return [];
    var array = [];
    var queue = [root];
    while (queue.length > 0) {
        var node = queue.shift();
        // If the node is null, add null to the array
        if (node === null) {
            array.push(null);
            continue;
        }
        // Add the node's value to the array
        array.push(node.val);
        // Add both children to the queue, even if they are null
        queue.push(node.left);
        queue.push(node.right);
    }
    // Remove trailing nulls to avoid unnecessary nulls at the end of the array
    while (array[array.length - 1] === null) {
        array.pop();
    }
    return array;
}
var input1 = [4, 2, 7, 1, 3];
var val = 2;
var root1 = arrayToTree(input1);
var root2 = searchBST(root1, val);
var output1 = treeToArray(root2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
