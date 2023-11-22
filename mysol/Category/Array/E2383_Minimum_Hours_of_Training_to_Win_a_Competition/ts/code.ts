
function largestLocal(grid: number[][]): number[][] {
  let n: number = grid.length;
  let maxLocal: number[][] = Array.from({ length: n - 2 }, () => Array(n - 2).fill(0));

  // Iterate over each cell of the maxLocal matrix
  for (let i = 0; i < n - 2; i++) {
      for (let j = 0; j < n - 2; j++) {
          maxLocal[i][j] = getMaxValue(grid, i, j);
      }
  }

  return maxLocal;
}

function getMaxValue(grid: number[][], row: number, col: number): number {
  let maxVal: number = Number.MIN_SAFE_INTEGER;

  // Iterate over the 3x3 matrix
  for (let i = row; i <= row + 2; i++) {
      for (let j = col; j <= col + 2; j++) {
          maxVal = Math.max(maxVal, grid[i][j]);
      }
  }

  return maxVal;
}

let input: number[][] = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]];
let output = largestLocal(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


