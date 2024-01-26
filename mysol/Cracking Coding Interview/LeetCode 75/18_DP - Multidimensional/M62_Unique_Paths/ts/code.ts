function uniquePaths(m: number, n: number): number {
  // Create a 2D array with all elements initialized to 1
  let dp: number[][] = new Array(m).fill(null).map(() => new Array(n).fill(1));

  // Compute the number of paths for each cell in the grid
  for (let i = 1; i < m; i++) {
      for (let j = 1; j < n; j++) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
  }

  // The bottom-right cell contains the total number of unique paths
  return dp[m - 1][n - 1];
};

let m = 3, n = 7;
let output1 = uniquePaths(m, n);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

