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

function invertTree(root: TreeNode | null): TreeNode | null {
    if (root === null) return null;

    // Recursively invert left and right subtrees
    const left = invertTree(root.left);
    const right = invertTree(root.right);

    // Swap left and right
    root.left = right;
    root.right = left;

    return root;
};

// Build tree from level-order array
function buildTree(arr: (number | null)[]): TreeNode | null {
    if (arr.length === 0) return null;
    const root = new TreeNode(arr[0]!);
    const queue: (TreeNode | null)[] = [root];
    let i = 1;

    while (i < arr.length) {
        const current = queue.shift();
        if (!current) continue;

        if (i < arr.length && arr[i] !== null) {
            current.left = new TreeNode(arr[i]!);
            queue.push(current.left);
        }
        i++;

        if (i < arr.length && arr[i] !== null) {
            current.right = new TreeNode(arr[i]!);
            queue.push(current.right);
        }
        i++;
    }

    return root;
}

// Serialize tree to level-order array
function serialize(root: TreeNode | null): (number | null)[] {
    const result: (number | null)[] = [];
    const queue: (TreeNode | null)[] = [root];

    while (queue.length) {
        const node = queue.shift();
        if (node) {
            result.push(node.val);
            queue.push(node.left);
            queue.push(node.right);
        } else {
            result.push(null);
        }
    }

    // Trim trailing nulls
    while (result[result.length - 1] === null) {
        result.pop();
    }

    return result;
}

// Deep copy of a tree
function deepCopy(root: TreeNode | null): TreeNode | null {
    if (root === null) return null;
    return new TreeNode(root.val, deepCopy(root.left), deepCopy(root.right));
}

const input = [4, 2, 7, 1, 3, 6, 9];
const root = buildTree(input);
const copiedTree = deepCopy(root);
const results = invertTree(copiedTree);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: <pre>' + JSON.stringify(serialize(root), null, 2) + 
    '</pre>Result = <pre>' + JSON.stringify(serialize(results), null, 2)  + '</pre>';
