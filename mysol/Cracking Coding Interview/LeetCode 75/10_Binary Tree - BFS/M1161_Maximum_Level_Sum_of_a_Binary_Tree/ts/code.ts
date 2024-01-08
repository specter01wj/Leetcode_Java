function rightSideView(root: TreeNode | null): number[] {
  if (!root) return [];

  const queue: (TreeNode | null)[] = [root];
  const visibleValues: number[] = [];

  while (queue.length > 0) {
      let levelSize = queue.length;
      for (let i = 0; i < levelSize; i++) {
          let currentNode = queue.shift();
          if (currentNode) {
              // If it's the last node in the current level, add it to the result array.
              if (i === levelSize - 1) {
                  visibleValues.push(currentNode.val);
              }
              // Add child nodes to the queue for the next level.
              if (currentNode.left) {
                  queue.push(currentNode.left);
              }
              if (currentNode.right) {
                  queue.push(currentNode.right);
              }
          }
      }
  }

  return visibleValues;
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

let input1 = [1,2,3,null,5,null,4];
let root1 = arrayToTree(input1);
let output1 = rightSideView(root1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

