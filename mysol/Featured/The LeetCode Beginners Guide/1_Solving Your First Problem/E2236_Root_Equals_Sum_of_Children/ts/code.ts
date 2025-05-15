class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
      this.val = val === undefined ? 0 : val;
      this.left = left === undefined ? null : left;
      this.right = right === undefined ? null : right;
  }
}

function checkTree(root: TreeNode | null): boolean {
  return root.val === root.left.val + root.right.val;
};

const left = new TreeNode(4);
const right = new TreeNode(6);
const root = new TreeNode(10, left, right);
const results = checkTree(root);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(root, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

