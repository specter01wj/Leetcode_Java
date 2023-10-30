
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

let input: number[][] = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]];
let output = checkXMatrix(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


