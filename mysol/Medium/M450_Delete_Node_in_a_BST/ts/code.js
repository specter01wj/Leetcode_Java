function deleteNode(root, key) {
    if (root === null) {
        return null;
    }
    // Search for the node
    if (key < root.val) {
        root.left = deleteNode(root.left, key);
    }
    else if (key > root.val) {
        root.right = deleteNode(root.right, key);
    }
    else {
        // Node with only one child or no child
        if (root.left === null) {
            return root.right;
        }
        else if (root.right === null) {
            return root.left;
        }
        // Node with two children: Get the inorder successor (smallest in the right subtree)
        root.val = minValue(root.right);
        // Delete the inorder successor
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}
;
function minValue(node) {
    var current = node;
    while (current && current.left !== null) {
        current = current.left;
    }
    if (current === null)
        throw new Error("The node cannot be null");
    return current.val;
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
var input1 = [5, 3, 6, 2, 4, null, 7];
var key = 3;
var root1 = arrayToTree(input1);
var root2 = deleteNode(root1, key);
var output1 = treeToArray(root2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
