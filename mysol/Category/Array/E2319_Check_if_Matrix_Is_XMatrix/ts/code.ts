
function checkXMatrix(grid: number[][]): boolean {
  let n = grid.length;
  
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (i === j || i + j === n - 1) {
        // For diagonal elements
        if (grid[i][j] === 0) {
          return false;
        }
      } else {
        // For non-diagonal elements
        if (grid[i][j] !== 0) {
          return false;
        }
      }
    }
  }
  
  return true;
}

let input: number[] = [[5,7,0],[0,3,1],[0,5,0]];
let output = checkXMatrix(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


