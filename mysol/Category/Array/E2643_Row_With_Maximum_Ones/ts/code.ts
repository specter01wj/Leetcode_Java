function findColumnWidth(grid: number[][]): number[] {
  const m: number = grid.length;    // Number of rows
  const n: number = grid[0].length; // Number of columns
  const ans: number[] = new Array(n).fill(0); // To store the width of each column

  // Iterate through each column
  for (let col = 0; col < n; col++) {
      let maxWidth = 0;

      // Iterate through each row in the current column
      for (let row = 0; row < m; row++) {
          // Get the length of the current number as a string
          const len: number = String(grid[row][col]).length;
          maxWidth = Math.max(maxWidth, len); // Update the maximum width for this column
      }

      ans[col] = maxWidth; // Store the maximum width for the current column
  }

  return ans; // Return the result as an array
};

const input: number[][] = [[1],[22],[333]];
const results = findColumnWidth(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

