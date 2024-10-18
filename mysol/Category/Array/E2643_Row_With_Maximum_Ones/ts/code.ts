function rowAndMaximumOnes(mat: number[][]): number[] {
  let maxOnes: number = 0; // Initialize the maximum number of ones to 0
  let rowIndex: number = 0; // Initialize the row index to 0

  // Iterate through each row
  for (let i = 0; i < mat.length; i++) {
      // Count the number of 1's in the current row
      let onesCount: number = mat[i].reduce((acc, num) => acc + num, 0);

      // Update the row with the maximum number of 1's
      if (onesCount > maxOnes) {
          maxOnes = onesCount;
          rowIndex = i;
      }
  }

  return [rowIndex, maxOnes]; // Return the row index and the max count of 1's
};

const input: number[][] = [[0,0],[1,1],[0,0]];
const results = rowAndMaximumOnes(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

