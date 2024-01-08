function deleteNode(root: TreeNode | null, key: number): TreeNode | null {
  if (root === null) {
      return null;
  }

  // Search for the node
  if (key < root.val) {
      root.left = deleteNode(root.left, key);
  } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
  } else {
      // Node with only one child or no child
      if (root.left === null) {
          return root.right;
      } else if (root.right === null) {
          return root.left;
      }

      // Node with two children: Get the inorder successor (smallest in the right subtree)
      root.val = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteNode(root.right, root.val);
  }

  return root;
};

function minValue(node: TreeNode | null): number {
  let current: TreeNode | null = node;
  while (current && current.left !== null) {
      current = current.left;
  }
  if (current === null) throw new Error("The node cannot be null");
  return current.val;
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

let input1 = [5,3,6,2,4,null,7];
let key = 2;
let root1 = arrayToTree(input1);
let root2 = deleteNode(root1, key);
let output1 = treeToArray(root2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

