function equalPairs(grid: number[][]): number {
  const n: number = grid.length;
  let count: number = 0;

  for (let row = 0; row < n; row++) {
      for (let col = 0; col < n; col++) {
          let r: number = 0;
          while (r < n && grid[row][r] === grid[r][col]) {
              r++;
          }
          if (r === n) {
              count++;
          }
      }
  }

  return count;
};

let input1 = [[3,2,1],[1,7,6],[2,7,7]]
let output1 = equalPairs(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

