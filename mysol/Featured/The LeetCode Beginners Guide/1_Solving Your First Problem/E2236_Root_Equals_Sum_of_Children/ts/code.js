class TreeNode {
    val;
    left;
    right;
    constructor(val, left, right) {
        this.val = val === undefined ? 0 : val;
        this.left = left === undefined ? null : left;
        this.right = right === undefined ? null : right;
    }
}
function checkTree(root) {
    return root.val === root.left.val + root.right.val;
}
;
const left = new TreeNode(4);
const right = new TreeNode(6);
const root = new TreeNode(10, left, right);
const results = checkTree(root);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(root, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
