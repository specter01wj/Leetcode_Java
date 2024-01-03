function leafSimilar(root1: TreeNode | null, root2: TreeNode | null): boolean {
  const leaves1: number[] = [];
  const leaves2: number[] = [];

  // Helper function to perform DFS and collect leaf values
  function dfs(node: TreeNode | null, leaves: number[]) {
      if (node === null) {
          return;
      }
      if (node.left === null && node.right === null) {
          leaves.push(node.val);
      }
      dfs(node.left, leaves);
      dfs(node.right, leaves);
  }

  // Collect leaf values for both trees
  dfs(root1, leaves1);
  dfs(root2, leaves2);

  // Compare the leaf value sequences
  if (leaves1.length !== leaves2.length) {
      return false;
  }
  for (let i = 0; i < leaves1.length; i++) {
      if (leaves1[i] !== leaves2[i]) {
          return false;
      }
  }
  return true;
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

let input1 = [3,5,1,6,2,9,8,null,null,7,4];
let input2 = [3,5,1,6,2,9,8,null,null,7,4];
let root1 = arrayToTree(input1);
let root2 = arrayToTree(input2);
let output1 = leafSimilar(root1, root2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

