function zigzagTraversal(grid: number[][]): number[] {
  const rows: number = grid.length;
  const cols: number = grid[0].length;
  const traversal: number[] = [];

  // Step 1: Traverse in zigzag order
  for (let i = 0; i < rows; i++) {
      if (i % 2 === 0) {
          // left to right
          for (let j = 0; j < cols; j++) {
              traversal.push(grid[i][j]);
          }
      } else {
          // right to left
          for (let j = cols - 1; j >= 0; j--) {
              traversal.push(grid[i][j]);
          }
      }
  }

  // Step 2: Skip every alternate cell globally
  const result: number[] = [];
  for (let i = 0; i < traversal.length; i += 2) {
      result.push(traversal[i]);
  }

  return result;
};

const input: number[][] = [[1,2],[3,4]];
const results = zigzagTraversal(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

