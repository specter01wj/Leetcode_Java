function longestZigZag(root: TreeNode | null): number {
  return dfs(root, -1, 0) - 1; // -1 for initial direction, 0 for initial length
}

function dfs(node: TreeNode | null, direction: number, length: number): number {
  if (node === null) return length;

  // Left direction = 0, Right direction = 1
  let leftLength: number = (direction === 1) ? dfs(node.left, 0, length + 1) : dfs(node.left, 0, 1);
  let rightLength: number = (direction === 0) ? dfs(node.right, 1, length + 1) : dfs(node.right, 1, 1);

  return Math.max(length, Math.max(leftLength, rightLength));
}

class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
  }
}

function arrayToTree(arr) {
  if (arr.length === 0) return null;

  let root = new TreeNode(arr[0]);
  let queue = [root];

  for (let i = 1; i < arr.length; i++) {
      let parent = queue[0];
      if (i % 2 === 1) {
          if (arr[i] != null) {
              parent.left = new TreeNode(arr[i]);
              queue.push(parent.left);
          }
      } else {
          if (arr[i] != null) {
              parent.right = new TreeNode(arr[i]);
              queue.push(parent.right);
          }
          queue.shift(); // Remove the processed node
      }
  }

  return root;
}

let input1 = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1];
let root1 = arrayToTree(input1);
let output1 = longestZigZag(root1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

