function goodNodes(root: TreeNode | null): number {
  function countGoodNodes(node: TreeNode | null, maxSoFar: number): number {
      if (node === null) {
          return 0;
      }

      let count = 0;

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
};

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

let input1 = [3,1,4,3,null,1,5];
let root1 = arrayToTree(input1);
let output1 = goodNodes(root1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

