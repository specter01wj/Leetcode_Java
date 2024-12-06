function findIndices(nums: number[], indexDifference: number, valueDifference: number): number[] {
  const n = nums.length;

  // Iterate through all pairs of indices (i, j)
  for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
          // Check if the conditions are satisfied
          if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
              return [i, j];
          }
      }
  }

  // If no such indices are found, return [-1, -1]
  return [-1, -1];
};

const input: number[] = [5,1,4,1];
const indexDifference: number = 2, valueDifference: number = 4;
const results = findIndices(input, indexDifference, valueDifference);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

