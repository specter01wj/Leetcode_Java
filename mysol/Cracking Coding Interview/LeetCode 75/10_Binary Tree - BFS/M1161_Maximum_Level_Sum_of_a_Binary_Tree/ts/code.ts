function maxLevelSum(root: TreeNode | null): number {
  if (!root) return 0;

  const queue: TreeNode[] = [root];
  let maxSum: number = -Infinity;
  let maxLevel: number = 1;
  let currentLevel: number = 1;

  while (queue.length > 0) {
      const levelSize: number = queue.length;
      let levelSum: number = 0;

      for (let i = 0; i < levelSize; i++) {
          const currentNode: TreeNode = queue.shift()!;
          levelSum += currentNode.val;

          if (currentNode.left) queue.push(currentNode.left);
          if (currentNode.right) queue.push(currentNode.right);
      }

      if (levelSum > maxSum) {
          maxSum = levelSum;
          maxLevel = currentLevel;
      }

      currentLevel++;
  }

  return maxLevel;
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

let input1 = [1,7,0,7,-8,null,null];




let root1 = arrayToTree(input1);
let output1 = maxLevelSum(root1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

