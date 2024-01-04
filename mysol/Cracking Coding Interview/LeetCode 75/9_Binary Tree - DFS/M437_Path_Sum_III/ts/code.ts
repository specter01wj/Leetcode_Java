function pathSum(root: TreeNode | null, targetSum: number): number {
  const prefixSumCount: Map<number, number> = new Map();
  prefixSumCount.set(0, 1); // Initialize with 0 sum having one count

  function findPathSum(node: TreeNode | null, currentSum: number): number {
      if (node === null) {
          return 0;
      }

      currentSum += node.val;
      let numPathsToCurr = prefixSumCount.get(currentSum - targetSum) || 0;

      // Update the prefixSumCount
      prefixSumCount.set(currentSum, (prefixSumCount.get(currentSum) || 0) + 1);

      // Count paths with sum = target in the left and right subtrees
      let result = numPathsToCurr + findPathSum(node.left, currentSum) + findPathSum(node.right, currentSum);

      // Restore the prefixSumCount (Backtrack)
      prefixSumCount.set(currentSum, prefixSumCount.get(currentSum) - 1);

      return result;
  }

  return findPathSum(root, 0);
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

let input1 = [10,5,-3,3,2,null,11,3,-2,null,1];
let targetSum = 8;
let root1 = arrayToTree(input1);
let output1 = pathSum(root1, targetSum);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

