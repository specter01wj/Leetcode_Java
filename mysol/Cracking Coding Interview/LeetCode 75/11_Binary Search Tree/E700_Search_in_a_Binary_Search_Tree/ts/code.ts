function searchBST(root: TreeNode | null, val: number): TreeNode | null {
  // Base case: if the root is null or the root's value is the target value
  if (root === null || root.val === val) {
      return root;
  }

  // If the target value is less than the root's value,
  // search in the left subtree. Otherwise, search in the right subtree.
  return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
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

function treeToArray(root) {
  if (!root) return [];

  let array = [];
  let queue = [root];

  while (queue.length > 0) {
      let node = queue.shift();

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

let input1 = [4,2,7,1,3];
let val = 2;
let root1 = arrayToTree(input1, val);
let root2 = searchBST(root1);
let output1 = treeToArray(root2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

